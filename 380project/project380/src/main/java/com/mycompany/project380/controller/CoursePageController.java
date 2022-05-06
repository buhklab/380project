package com.mycompany.project380.controller;

import com.mycompany.project380.exception.CommentNotFound;
import com.mycompany.project380.model.Answer;
import com.mycompany.project380.model.Comment;
import com.mycompany.project380.model.Course;
import com.mycompany.project380.model.Lecture;
import com.mycompany.project380.model.Note;
import com.mycompany.project380.model.Question;
import com.mycompany.project380.model.VotedAnswer;
import com.mycompany.project380.service.AnswerService;
import com.mycompany.project380.service.CommentService;
import com.mycompany.project380.service.CourseService;
import com.mycompany.project380.service.LectureService;
import com.mycompany.project380.service.NoteService;
import com.mycompany.project380.service.QuestionService;
import com.mycompany.project380.service.VotedAnswerService;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a1742
 */
@Controller
@RequestMapping("/course")
public class CoursePageController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private LectureService lecService;
    @Autowired
    private CommentService cmtService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService ansService;
    @Autowired
    private VotedAnswerService vansService;

    Course currentCourse = new Course();

    @GetMapping({"", "/courselist"})
    public String list(ModelMap model) {
        model.addAttribute("courseDB", courseService.getCourses());
        model.addAttribute("lectureDB", lecService.getLectures());
        List<Question> questions = questionService.getQuestions();
        List<Answer> answers = ansService.getAnswers();
        List<VotedAnswer> vans = vansService.getVotedAnswers();
        model.addAttribute("questionDB", questions);
        model.addAttribute("answerDB", answers);
        model.addAttribute("vanswerDB", vans);
        return "courselist";
    }

    @GetMapping("/view/Lecture")
    public String showLecture(@RequestParam("lid") String lID, ModelMap model) {
        Lecture currentLecture = lecService.getLecture(Long.parseLong(lID));
        List<Comment> cmts = new ArrayList<>();
        cmts = cmtService.getCommentBylID(lID);
        List<Note> notes = noteService.getNoteBylID(lID);
        model.addAttribute("noteDB", notes);
        model.addAttribute("currentLec", currentLecture);
        model.addAttribute("cmtDB", cmts);
        return "showlecdetail";
    }

    @GetMapping("/view/listLecture")
    public String listLecture(@RequestParam("courseID") String cID, ModelMap model) {
        List<Course> allCourses = new ArrayList<>();
        allCourses = courseService.getCourses();
        List<Lecture> allLectures = new ArrayList<>();
        allLectures = lecService.getLectures();
        List<Lecture> lectures = new ArrayList<>();

        List< Note> lecNote = new ArrayList<>();
        List<Note> tutNote = new ArrayList<>();
        for (Course c : allCourses) {
            if (c.getCourseId() == Long.parseLong(cID)) {
                currentCourse = c;
                break;
            }
        }
        for (Lecture l : allLectures) {
            if (l.getCourseID() == Long.parseLong(cID)) {
                lectures.add(l);
            }
        }
        model.addAttribute("currentCourse", currentCourse);
        model.addAttribute("lecture", lectures);
        return "listLecture";
    }

    // ----------------------------------------------------------------------------------------------------------------//
    @GetMapping("/create/comment/Lecture")
    public ModelAndView create() {
        return new ModelAndView("add", "ticketForm", new Form());
    }

    @PostMapping("/create/comment/Lecture")
    public String create(Form form, Principal principal, @RequestParam("lid") String lid, @RequestParam("courseID") String cid, ModelMap model) throws IOException {
        // Course c = (Course)model.getAttribute("currentCourse");
        // long commentID = cmtService.createComment(principal.getName(),form.getBody(),lid,c.getTitle(),c.get);
//long commentID = cmtService.createComment("jason","0","abc",Long.toString(c.getCourseId()),lid);
        Question q = new Question();
        String questionid = Long.toString(q.getQuestionId());
        long commentID = cmtService.createComment(principal.getName(), questionid, form.getBody(), cid, lid);
        return "redirect:/course/view/Lecture?courseID=" + cid + "&lid=" + lid;
    }

    @GetMapping("/comment/delete")
    public String deleteComment(@RequestParam("commentID") long commentID, @RequestParam("lid") String lid, @RequestParam("courseID") String cid)
            throws CommentNotFound {
        cmtService.delete(commentID);
        return "redirect:/course/view/Lecture?courseID=" + cid + "&lid=" + lid;
    }

    @GetMapping("/view/studentslist")
    public String listStudent() {
        return "liststudent";
    }

    /*
    @GetMapping("/view/AddStudent")
    public String addStudent() {
        Student s = new Student();
        String studentID = Long.toString(q.get());
        long commentID = cmtService.createComment(principal.getName(), questionid, form.getBody(), cid, lid);
        return "redirect:/course/view/Lecture?courseID=" + cid + "&lid=" + lid;
        return "liststudent";
    }
     */
    public static class Form {

        private String subject;
        private String body;
        private List<MultipartFile> attachments;

        // Getters and Setters of subject, body, attachments
        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public List<MultipartFile> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<MultipartFile> attachments) {
            this.attachments = attachments;
        }
    }
}

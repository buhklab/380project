package com.mycompany.project380.controller;

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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("questionDB",questions);
        model.addAttribute("answerDB",answers);
        model.addAttribute("vanswerDB",vans);
        return "courselist";
    }

    @GetMapping("/Lecture")
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

    @GetMapping("/listLecture")
    public String listLecture(@RequestParam("courseID") String cID, ModelMap model) {
        List<Course> allCourses = new ArrayList<>();
        allCourses = courseService.getCourses();
        List<Lecture> allLectures = new ArrayList<>();
        allLectures = lecService.getLectures();
        List<Lecture> lectures = new ArrayList<>();

        List < Note > lecNote = new ArrayList<>();
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
    
}

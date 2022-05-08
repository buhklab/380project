/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.controller;

import com.mycompany.project380.exception.LectureNotFound;
import com.mycompany.project380.exception.MaterialNotFound;
import com.mycompany.project380.model.Lecture;
import com.mycompany.project380.model.Material;
import com.mycompany.project380.service.LectureService;
import com.mycompany.project380.service.MaterialService;
import com.mycompany.project380.view.DownloadingView;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;



@Controller
@RequestMapping("/course/view")
public class LectureController {

    @Autowired
    private LectureService lectureService;
    @Autowired
    private MaterialService materialService;

    // Controller methods, Form object, ...
    @GetMapping({"", "/list"})
    public String list(ModelMap model) {
        model.addAttribute("lectureDatabase", lectureService.getLectures());
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("uploadMaterial", "lectureForm", new Form());
    }

    public static class Form {

        private Long courseId;
        private String title;
        private List<MultipartFile> materials;

        // Getters and Setters of subject, body, attachments

        public Long getCourseId() {
            return courseId;
        }

        public void setCourseId(Long courseId) {
            this.courseId = courseId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<MultipartFile> getMaterials() {
            return materials;
        }

        public void setMaterials(List<MultipartFile> materials) {
            this.materials = materials;
        }

    }

    @PostMapping("/create")
    public String create(Form form) throws IOException {
        long lectureId = lectureService.createLecture(
                form.getTitle(), form.getCourseId(), form.getMaterials());
        return "redirect:/course/view/info/" + lectureId;
    }

    @GetMapping("/info/{lectureId}")
    public String view(@PathVariable("lectureId") long lectureId, ModelMap model) {
        Lecture lecture = lectureService.getLecture(lectureId);
        if (lecture == null) {
            return "redirect:/course";
        }
        model.addAttribute("lecture", lecture);
        return "view";
    }

    @GetMapping("/{lectureId}/material/{material:.+}")
    public View download(@PathVariable("lectureId") long lectureId,
            @PathVariable("material") String name) {
        Material material = materialService.getMaterial(lectureId, name);
        if (material != null) {
            return new DownloadingView(material.getName(),
                    material.getMimeContentType(), material.getContents());
        }
        return new RedirectView("/lecture", true);
    }

    @GetMapping("/lecture/{lectureId}/delete/{material:.+}")
    public String deleteAttachment(@PathVariable("lectureId") long lectureId,
            @PathVariable("material") String name) throws MaterialNotFound {
        lectureService.deleteMaterial(lectureId, name);
        return "redirect:/lecture/edit/" + lectureId;
    }

    @GetMapping("/edit/{lectureId}")
    public ModelAndView showEdit(@PathVariable("lectureId") long lectureId,
            Principal principal, HttpServletRequest request) {
        Lecture lecture = lectureService.getLecture(lectureId);
        if (lecture == null
                || (!request.isUserInRole("ROLE_LECTURER"))) {
            return new ModelAndView(new RedirectView("/lecture", true));
        }
        ModelAndView modelAndView = new ModelAndView("editLecture");// jsp name
        modelAndView.addObject("lecture", lecture);
        Form lectureForm = new Form();
        lectureForm.setCourseId(lecture.getCourseID());
        lectureForm.setTitle(lecture.getTitle());
        modelAndView.addObject("lectureForm", lectureForm);
        return modelAndView;
    }

    @PostMapping("/edit/{lectureId}")
    public String edit(@PathVariable("lectureId") long lectureId, Form form,
            Principal principal, HttpServletRequest request)
            throws IOException, LectureNotFound {
        Lecture lecture = lectureService.getLecture(lectureId);
        if (lecture == null
                || (!request.isUserInRole("ROLE_LECTURER"))) {
            return "redirect:/course";
        }
        lectureService.updateLecture(lectureId, form.getTitle(),
                form.getCourseId(), form.getMaterials());
        return "redirect:/lecture/view/" + lectureId;
    }

    @GetMapping("/delete/{lectureId}")
    public String deleteTicket(@PathVariable("lectureId") long lectureId)
            throws LectureNotFound {
        lectureService.delete(lectureId);
        return "redirect:/course";
    }

}


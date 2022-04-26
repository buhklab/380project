/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.CourseRepository;
import com.mycompany.project380.dao.LectureRepository;
import com.mycompany.project380.model.Course;
import com.mycompany.project380.model.Lecture;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author a1742
 */

@Service
public class LectureService {
    
    @Resource
    private LectureRepository lecRepo;
    
    @Transactional
    public List<Lecture> getLectures(){
        return lecRepo.findAll();
    }
    
    @Transactional
    public Lecture getLecture(long id) {
        return lecRepo.findById(id).orElse(null);
    }
}

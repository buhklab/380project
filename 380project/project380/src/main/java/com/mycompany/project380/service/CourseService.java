/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.CourseRepository;
import com.mycompany.project380.model.Course;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author a1742
 */

@Service
public class CourseService {
    
    @Resource
    private CourseRepository courseRepo;
    
    @Transactional
    public List<Course> getCourses(){
        return courseRepo.findAll();
    }
    
    @Transactional
    public Course getCourse(long id) {
        return courseRepo.findById(id).orElse(null);
    }
}

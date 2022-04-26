/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.CommentRepository;
import com.mycompany.project380.model.Comment;
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
public class CommentService {
    
    @Resource
    private CommentRepository cmtRepo;
    
    @Transactional
    public List<Comment> getComments(){
        return cmtRepo.findAll();
    }
    
    @Transactional
    public Comment getComment(long id) {
        return cmtRepo.findById(id).orElse(null);
    }
}

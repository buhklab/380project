/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.CommentRepository;
import com.mycompany.project380.model.Comment;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;
import com.mycompany.project380.exception.CommentNotFound;


/**
 *
 * @author a1742
 */
@Service
public class CommentService {

    @Resource
    private CommentRepository cmtRepo;

    @Transactional
    public List<Comment> getCommentBylID(String cid) {
        return cmtRepo.findByLectureID(cid);
    }

    @Transactional
    public List<Comment> getCommentByQID(String qid) {
        return cmtRepo.findByQuestionID(qid);
    }

    @Transactional
    public List<Comment> getComments() {
        return cmtRepo.findAll();
    }

    @Transactional
    public Comment getComment(long id) {
        return cmtRepo.findById(id).orElse(null);
    }

    @Transactional
    public long createComment(String userName, String questionID, String content, String courseID, String lectureID/*,long id*/ ) throws IOException {
        Comment comment = new Comment();
        comment.setUsername(userName);
        comment.setQuestionID(questionID);
        comment.setContent(content);
        comment.setCourseIDStringint(courseID);
        comment.setLectureID(lectureID);
        //comment.setId(id);
        /*
        for (MultipartFile filePart : attachments) {
            Attachment attachment = new Attachment();
            attachment.setName(filePart.getOriginalFilename());
            attachment.setMimeContentType(filePart.getContentType());
            attachment.setContents(filePart.getBytes());
            attachment.setTicket(ticket);
            if (attachment.getName() != null && attachment.getName().length() > 0
                    && attachment.getContents() != null
                    && attachment.getContents().length > 0) {
                ticket.getAttachments().add(attachment);
            }
        }
         */
        Comment savedComment = cmtRepo.save(comment);
        return savedComment.getId();
    }
    @Transactional(rollbackFor = CommentNotFound.class)
    public void delete(long id) throws CommentNotFound {
        Comment deletedcomment = cmtRepo.findById(id).orElse(null);
        if (deletedcomment == null) {
            throw new CommentNotFound();
        }
        cmtRepo.delete(deletedcomment);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.NoteRepository;
import com.mycompany.project380.model.Note;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author a1742
 */

@Service
public class NoteService {
    
    @Resource
    private NoteRepository noteRepo;
    
    @Transactional
    public List<Note> getNoteBylID(String lid){
        return noteRepo.findByLectureID(lid);
    }
    
    @Transactional
    public List<Note> getNoteByCID(String cid){
        return noteRepo.findByCourseID(cid);
    }
    
    @Transactional
    public List<Note> getNotes(){
        return noteRepo.findAll();
    }
    
    @Transactional
    public Note getNote(long id) {
        return noteRepo.findById(id).orElse(null);
    }
}

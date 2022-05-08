/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.LectureRepository;
import com.mycompany.project380.dao.MaterialRepository;
import com.mycompany.project380.exception.LectureNotFound;
import com.mycompany.project380.exception.MaterialNotFound;
import com.mycompany.project380.model.Lecture;
import com.mycompany.project380.model.Material;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;





/**
 *
 * @author a1742
 */
@Service
public class LectureService {

    @Resource
    private LectureRepository lecRepo;

    @Resource
    private MaterialRepository materialRepo;

    @Transactional
    public List<Lecture> getLectures() {
        return lecRepo.findAll();
    }

    @Transactional
    public Lecture getLecture(long id) {
        return lecRepo.findById(id).orElse(null);
    }

    @Transactional(rollbackFor = LectureNotFound.class)
    public void delete(long id) throws LectureNotFound {
        Lecture deletedLecture = lecRepo.findById(id).orElse(null);
        if (deletedLecture == null) {
            throw new LectureNotFound();
        }
        lecRepo.delete(deletedLecture);
    }

    @Transactional(rollbackFor = MaterialNotFound.class)
    public void deleteMaterial(long LectureId, String name ) throws MaterialNotFound {
        Lecture lecture = lecRepo.findById(LectureId).orElse(null);
        for (Material material : lecture.getMaterial()) {
            if (material.getName().equals(name)) {
                lecture.deleteMaterial(material);
                lecRepo.save(lecture);
                return;
            }
        }
        throw new MaterialNotFound();
    }

    @Transactional
    public long createLecture(String title, Long courseId, List<MultipartFile> materials) throws IOException {
        Lecture lecture = new Lecture();
        lecture.setTitle(title);
        lecture.setCourseID(courseId);
        for (MultipartFile filePart : materials) {
            Material material = new Material();
            material.setName(filePart.getOriginalFilename());
            material.setMimeContentType(filePart.getContentType());
            material.setContents(filePart.getBytes());
            material.setLecture(lecture);
            if (material.getName() != null && material.getName().length() > 0
                    && material.getContents() != null
                    && material.getContents().length > 0) {
                lecture.getMaterial().add(material);
            }
        }
        Lecture savedLecture = lecRepo.save(lecture);
        return savedLecture.getLectureID();
    }

    @Transactional(rollbackFor = LectureNotFound.class)
    public void updateLecture(long lectureId, String title,
            Long courseId, List<MultipartFile> materials)
            throws IOException, LectureNotFound {
        Lecture updatedLecture = lecRepo.findById(lectureId).orElse(null);
        if (updatedLecture == null) {
            throw new LectureNotFound();
        }
        updatedLecture.setTitle(title);
        updatedLecture.setCourseID(courseId);
        for (MultipartFile filePart : materials) {
            Material material = new Material();
            material.setName(filePart.getOriginalFilename());
            material.setMimeContentType(filePart.getContentType());
            material.setContents(filePart.getBytes());
            material.setLecture(updatedLecture);
            if (material.getName() != null && material.getName().length() > 0
                    && material.getContents() != null
                    && material.getContents().length > 0) {
                updatedLecture.getMaterial().add(material);
            }
        }
        lecRepo.save(updatedLecture);
    }

}

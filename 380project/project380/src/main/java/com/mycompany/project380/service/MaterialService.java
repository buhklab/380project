/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.MaterialRepository;
import com.mycompany.project380.model.Material;
import com.mycompany.project380.model.Note;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Resource
    private MaterialRepository materialRepo;

    @Transactional
    public Material getMaterial(long lectureId, String name) {
        return materialRepo.findByLectureIdAndName(lectureId, name);
    }

    @Transactional
    public List<Material> getMaterials() {
        return materialRepo.findAll();
    }
}

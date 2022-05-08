/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.dao;

import com.mycompany.project380.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MaterialRepository extends JpaRepository<Material, Long> {

    public Material findByLectureIdAndName(long lectureId, String name);

}


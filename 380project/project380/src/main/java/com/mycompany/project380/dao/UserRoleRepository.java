/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.dao;

import com.mycompany.project380.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author a1742
 */
public interface UserRoleRepository extends JpaRepository<User, Integer>  {
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author a1742
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;

    private String password;

    private String fullname;

    private String phonenbr;

    private String address;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> roles = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String fullname, String phonenbr, String address, String[] roles) {
        this.username = username;
        this.password = "{noop}" + password;
        this.fullname =  fullname;
        this.phonenbr = phonenbr;
        this.address =  address;
        for (String role : roles) {
            this.roles.add(new UserRole(this, role));
        }
    }
    // getter, setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhonenbr() {
        return phonenbr;
    }

    public void setPhonenbr(String phonenbr) {
        this.phonenbr = phonenbr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
    
}

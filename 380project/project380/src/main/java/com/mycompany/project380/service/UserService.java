/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.service;

import com.mycompany.project380.dao.UserRepository;
import com.mycompany.project380.model.UserRole;
import com.mycompany.project380.exception.UserNotFound;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Resource
    UserRepository UserRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        com.mycompany.project380.model.User user = UserRepo.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
/*
    @Transactional(rollbackFor = UserNotFound.class)
    public void updateUser(String id,String username, String fullname, String phonenbr, String address,  String password,List<UserRole> userRole)
            throws IOException, UserNotFound {
        com.mycompany.project380.model.User updatedUser = UserRepo.findById(id).orElse(null);
        if (updatedUser == null) {
            throw new UserNotFound();
        }

        updatedUser.setUsername(username);
        updatedUser.setFullname(fullname);
        updatedUser.setPhonenbr(phonenbr);
        updatedUser.setAddress(address);
        updatedUser.setPassword(password);
        updatedUser.setRoles(userRole);

        UserRepo.save(updatedUser);
    }
*/
}

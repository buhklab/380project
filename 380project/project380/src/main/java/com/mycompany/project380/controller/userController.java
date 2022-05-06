/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project380.controller;

import com.mycompany.project380.dao.UserRepository;
import com.mycompany.project380.model.User;
import com.mycompany.project380.model.UserRole;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/create")
public class userController {

    @Resource
    UserRepository userRepo;

    @GetMapping({"", "/list"})
    public String list(ModelMap model) {
        model.addAttribute("AllUsers", userRepo.findAll());
        return "liststudent";
    }

    public static class Form {

        private String username;
        private String password;
        private String fullname;
        private String phonenbr;
        private String address;
        private String[] roles;
        // ... getters and setters for each of the properties

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

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }
    }

    @GetMapping("/signup")
    public ModelAndView create() {
        return new ModelAndView("register", "user", new Form());
    }

    @PostMapping("/signup")
    public View create(Form form) throws IOException {
        User user = new User(form.getUsername(), form.getPassword(), form.getFullname(), form.getPhonenbr(), form.getAddress(), form.getRoles());
        userRepo.save(user);
        return new RedirectView("/course", true);
    }

//    @GetMapping("/delete/{username}")
//    public View deleteTicket(@PathVariable("username") String username) {
//        userRepo.delete(userRepo.findById(username).orElse(null));
//        return new RedirectView("/user/list", true);
//    }
    @GetMapping("/user")
    public ModelAndView createUser() {
        return new ModelAndView("addUser", "User", new Form());
    }

    @PostMapping("/user")
    public View createUser(Form form) throws IOException {
        User user = new User(form.getUsername(), form.getPassword(), form.getFullname(), form.getPhonenbr(), form.getAddress(), form.getRoles());
        userRepo.save(user);
        return new RedirectView("/course", true);
    }

    @GetMapping("/user/delete")
    public View deleteUser(@RequestParam("username") String username) {
        userRepo.delete(userRepo.findById(username).orElse(null));
        return new RedirectView("/create/list", true);

    }

    @GetMapping("/user/edit")
    public ModelAndView showEdit(@RequestParam("username") String username,
            Principal principal, HttpServletRequest request) {
        User user = userRepo.findById(username).orElse(null);;
        if (user == null /*|| (!request.isUserInRole("ROLE_ADMIN")&& !principal.getName().equals(user.getUsername()))*/) {
            return new ModelAndView(new RedirectView("/course", true));
        }

        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", user);

        Form userForm = new Form();
        userForm.setUsername(user.getUsername());
        userForm.setFullname(user.getFullname());
        userForm.setPhonenbr(user.getPhonenbr());
        userForm.setPassword(user.getPassword());
        userForm.setAddress(user.getAddress());
/*
        List<UserRole> UserRoleList = user.getRoles();
        String[] array = new String[UserRoleList.size()];
        int index = 0;
        for (Object value : UserRoleList) {
            array[index] = (String) value;
            index++;
        }

        userForm.setRoles(array);
*/
        modelAndView.addObject("userForm", userForm);

        return modelAndView;
    }
    /*
    @PostMapping("/edit/{ticketId}")
    public String editUser(@PathVariable("ticketId") long ticketId, Form form,
            Principal principal, HttpServletRequest request)
            throws IOException, TicketNotFound {
        Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket == null
                || (!request.isUserInRole("ROLE_ADMIN")
                && !principal.getName().equals(ticket.getCustomerName()))) {
            return "redirect:/ticket/list";
        }

        ticketService.updateTicket(ticketId, form.getSubject(),
                form.getBody(), form.getAttachments());
        return "redirect:/ticket/view/" + ticketId;
    }
     */
}

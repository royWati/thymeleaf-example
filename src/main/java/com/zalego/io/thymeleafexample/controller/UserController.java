package com.zalego.io.thymeleafexample.controller;

import com.zalego.io.thymeleafexample.entities.Users;
import com.zalego.io.thymeleafexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping(value = "/addUser",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Users insertUser(Users users){
        return service.insertUser(users);
    }
    @GetMapping
    public List<Users> fetchAll(){
        return service.findAllUsers();
    }

    @PostMapping(value = "/authorize",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Users users(Users users){
        return service.authorizeUser(users);
    }

    @GetMapping("/dashboard")
    public String viewDashboard(Model model){
        return "dashboard";
    }
}

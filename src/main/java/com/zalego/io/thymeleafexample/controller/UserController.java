package com.zalego.io.thymeleafexample.controller;

import com.zalego.io.thymeleafexample.entities.Users;
import com.zalego.io.thymeleafexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("/addUser")
    public Users insertUser(@RequestBody Users users){
        return service.insertUser(users);
    }
    @GetMapping
    public List<Users> fetchAll(){
        return service.findAllUsers();
    }

    @GetMapping("/authorize")
    public Users users(@RequestBody Users users){
        return service.authorizeUser(users);
    }
}

package com.zalego.io.thymeleafexample.controller;

import com.zalego.io.thymeleafexample.DO.Login;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/thyme")
public class ThymeController {

    @PostMapping(value = {"/","/java"},
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public String ShowPage(Model model, Login login){
        model.addAttribute("email","Welcome "+
                login.getUsername()+" to our Java Class");
        return "java";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "registration";
    }
    @GetMapping("/dashboard")
    public String viewDashboard(Model model){
        return "dashboard";
    }
    @GetMapping("/add-hotel")
    public String addHotel(Model model){
        return "add-hotel";
    }
}

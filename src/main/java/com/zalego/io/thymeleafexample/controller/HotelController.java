package com.zalego.io.thymeleafexample.controller;

import com.zalego.io.thymeleafexample.entities.Hotel;
import com.zalego.io.thymeleafexample.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService service;

    @PostMapping
    public Hotel addHotel(Hotel hotel){
        return service.addHotel(hotel);
    }
    @GetMapping
    public List<Hotel> findAll(){
        return service.findAll();
    }

}

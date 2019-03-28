package com.zalego.io.thymeleafexample.controller;

import com.zalego.io.thymeleafexample.entities.Hotel;
import com.zalego.io.thymeleafexample.entities.Users;
import com.zalego.io.thymeleafexample.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService service;

    @PostMapping
    public Hotel addHotel(@RequestBody  Hotel hotel){
        return service.addHotel(hotel);
    }
    @GetMapping
    public List<Hotel> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public List<Hotel> findHotelByUser(@PathVariable long id){
        Users user = new Users();
        user.setId(id);
        return  service.findByHotelsByUser(user);
    }
    @DeleteMapping("/{id}")
    public void DeleteHotel(@PathVariable long id){
        service.deleteHotel(id);
    }
}

package com.zalego.io.thymeleafexample.controller;

import com.zalego.io.thymeleafexample.entities.Location;
import com.zalego.io.thymeleafexample.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService service;

    @PostMapping
    public Location addLocation(
            @RequestBody  Location location){
        return service.addLocation(location);
    }
    @GetMapping
    public List<Location> findAll(){
        return service.findAll();
    }
}

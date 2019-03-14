package com.zalego.io.thymeleafexample.service;

import com.zalego.io.thymeleafexample.entities.Location;
import com.zalego.io.thymeleafexample.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    public List<Location> findAll(){
        return repository.findAll();
    }
    public Location addLocation(Location location){
        return repository.save(location);
    }


}

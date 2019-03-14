package com.zalego.io.thymeleafexample.service;

import com.zalego.io.thymeleafexample.entities.Hotel;
import com.zalego.io.thymeleafexample.entities.Location;
import com.zalego.io.thymeleafexample.entities.Users;
import com.zalego.io.thymeleafexample.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repository;

    public List<Hotel> findAll(){
        return repository.findAll();
    }
    public Hotel addHotel(Hotel hotel){
        return repository.save(hotel);
    }
    public Hotel findById(Long id){
        Hotel[] hotels = {new Hotel()};
        repository.findById(id).ifPresent(hotel -> {
            hotels[0] = hotel;
        });
        return hotels[0];
    }

    public List<Hotel> findByHotelsByLocation(Location location){
        List<Hotel> hotels = new ArrayList<>();
        repository.findByLocation(location).ifPresent(hotel -> {
            hotels.add(hotel);
        });
        return hotels;
    }

    public List<Hotel> findByHotelsByUser(Users users){
        List<Hotel> hotels = new ArrayList<>();
        repository.findByUser(users).ifPresent(hotel -> {
            hotels.add(hotel);
        });
        return hotels;
    }

}

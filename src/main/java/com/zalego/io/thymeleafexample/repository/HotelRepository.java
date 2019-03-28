package com.zalego.io.thymeleafexample.repository;

import com.zalego.io.thymeleafexample.entities.Hotel;
import com.zalego.io.thymeleafexample.entities.Location;
import com.zalego.io.thymeleafexample.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    Optional<Hotel> findByLocation(Location location);
    List<Hotel> findByUser(Users users);
    List<Hotel> findHotelByDeletedStatus(boolean status);
}

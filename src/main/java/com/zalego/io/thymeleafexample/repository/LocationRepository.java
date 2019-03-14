package com.zalego.io.thymeleafexample.repository;

import com.zalego.io.thymeleafexample.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

}

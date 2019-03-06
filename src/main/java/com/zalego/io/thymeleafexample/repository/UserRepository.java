package com.zalego.io.thymeleafexample.repository;

import com.zalego.io.thymeleafexample.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users,Long>{

    @Override
    Optional<Users> findById(Long aLong);
    Optional<Users> findByUuid(UUID uuid);
    Optional<Users> findByEmailAndAndPassword(String email,
                                              String password);
}
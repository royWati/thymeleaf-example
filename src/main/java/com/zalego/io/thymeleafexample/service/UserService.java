package com.zalego.io.thymeleafexample.service;

import com.zalego.io.thymeleafexample.entities.Users;
import com.zalego.io.thymeleafexample.exceptions.UnAuthorizedAccess;
import com.zalego.io.thymeleafexample.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<Users> findAllUsers(){
        return repo.findAll();
    }
    public Users insertUser(Users users){
        repo.save(users);
        final Users[] user = {new Users()};
        repo.findByEmailAndAndPassword(users.getEmail(),
                users.getPassword()).
                ifPresent(users1 ->{
                    user[0] =users1;
                } );
        return user[0];
    }
    public Users authorizeUser(Users users){
        Users[] user = {new Users()};
        repo.findByEmailAndAndPassword(users.getEmail(),
                users.getPassword()).ifPresent(
                        users1 -> {
                            user[0] = users1;
                        }
        );

        if (user[0].getEmail()==null)
            throw new UnAuthorizedAccess();
        else
            return user[0];
    }

}

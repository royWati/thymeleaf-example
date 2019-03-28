package com.zalego.io.thymeleafexample.entities;

import com.zalego.io.thymeleafexample.configs.Encrypt;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
public class Users extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "passowrd")
    private String password;
    @Column(name = "phone")
    private BigInteger phone;

//    @OneToMany(mappedBy = "user")
//    private List<Hotel> hotels=new ArrayList<>();

//    public List<Hotel> getHotels() {
//        return hotels;
//    }
//
//    public void setHotels(List<Hotel> hotels) {
//        this.hotels = hotels;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.password = new Encrypt().EncryptPassword(password) ;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }
}

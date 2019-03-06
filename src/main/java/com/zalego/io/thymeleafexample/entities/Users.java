package com.zalego.io.thymeleafexample.entities;

import com.zalego.io.thymeleafexample.configs.Encrypt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

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

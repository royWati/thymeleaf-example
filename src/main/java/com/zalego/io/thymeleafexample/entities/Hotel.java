package com.zalego.io.thymeleafexample.entities;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Hotel")
public class Hotel extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "location",
    nullable = false)
    private Location location;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private BigInteger phone;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id",
    nullable = false)
    private Users user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
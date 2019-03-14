package com.zalego.io.thymeleafexample.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location extends BaseEntity{

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "id",
    fetch = FetchType.LAZY)
    private Set<Hotel> hotel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(Set<Hotel> hotel) {
        this.hotel = hotel;
    }
}

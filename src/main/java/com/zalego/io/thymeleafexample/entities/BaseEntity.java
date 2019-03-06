package com.zalego.io.thymeleafexample.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "deletedStatus",
            columnDefinition = "boolean default false")
    private boolean deletedStatus;

    @Column(name = "createdOn")
    private LocalDateTime createdOn;

    public UUID generateUUID(){
        return UUID.randomUUID();
    }
    @PrePersist
    public void addData(){
        this.createdOn = LocalDateTime.now();
        this.deletedStatus = false;
        this.uuid = generateUUID();
    }

    public BaseEntity(UUID uuid, boolean deletedStatus, LocalDateTime createdOn) {
        this.uuid = uuid;
        this.deletedStatus = deletedStatus;
        this.createdOn = createdOn;
    }

    public BaseEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isDeletedStatus() {
        return deletedStatus;
    }

    public void setDeletedStatus(boolean deletedStatus) {
        this.deletedStatus = deletedStatus;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}

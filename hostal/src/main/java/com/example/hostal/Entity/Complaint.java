package com.example.hostal.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "StudentId")
    private int studentId;

    @Column(name = "ItemID")
    private String itemID;

    @Column(name = "ItemName")
    private String itemName;

    @Column(name = "RoomID")
    private String roomId;

    @Column(name = "Image")
    private String image;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status")
    private String status;


    public Complaint() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Complaint(Integer id, int studentId, String itemID, String itemName, String roomId, String image, String description, String status) {
        this.id = id;
        this.studentId = studentId;
        this.itemID = itemID;
        this.itemName = itemName;
        this.roomId = roomId;
        this.image = image;
        this.description = description;
        this.status = status;
    }

    // Constructors, getters, and setters
}

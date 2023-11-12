package com.example.hostal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "f_name")
    private String f_name;

    @Column(name = "l_name")
    private String l_name;

    @Column(name = "RoomID")
    private String roomId;

    @Column(name = "email")
    private String email;

    @Column(name ="password")
    private String password;

    public Student() {

    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getfName() {
        return f_name;
    }

    public void setfName(String fName) {
        this.f_name = fName;
    }

    public String getlName() {
        return l_name;
    }

    public void setlName(String lName) {
        this.l_name = lName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(Integer id, String fName, String lName, String roomId, String email, String password) {
        this.id = id;
        this.f_name = fName;
        this.l_name = lName;
        this.roomId = roomId;
        this.email = email;
        this.password = password;
    }
}

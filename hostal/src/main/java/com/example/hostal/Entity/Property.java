package com.example.hostal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "ItemName")
    private String itemName;

    @Column(name = "RoomId")
    private String RoomId;

    public Property() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getitemId() {
        return itemId;
    }

    public void setitemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRoomId() {
        return RoomId;
    }

    public void setRoomId(String roomId) {
        RoomId = roomId;
    }

    public Property(Integer id, String itemid, String itemName, String roomId) {
        this.id = id;
        this.itemId = itemid;
        this.itemName = itemName;
        RoomId = roomId;
    }
}

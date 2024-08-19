/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xupi.tutorcrud.persistance;

/**
 *
 * @author erick
 */
public class TutorDTO {
    protected int id;
    protected String name;
    protected String phone;
    protected boolean isDirector;
    protected int houseId;

    public TutorDTO(int id, String name, String phone, boolean isDirector, int houseId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.isDirector = isDirector;
        this.houseId = houseId;
    }

    public TutorDTO() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isDirector() {
        return isDirector;
    }
   

    public int getHouseId() {
        return houseId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsDirector(boolean isDirector) {
        this.isDirector = isDirector;
    }
    
    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetcare.model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author davidcarrascal
 */
public class Owner {
    private int id;
    private String identificationType;
    private String identificationNumber;
    private String fullname;
    private String phone;
    private String email;
    private String address;
    private boolean active;
    private Date registeredDate;

    public int getId() {
        return id;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }
    
    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public boolean isActive() {
        return active;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public void setDocumentNumber(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFullName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setState(boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}

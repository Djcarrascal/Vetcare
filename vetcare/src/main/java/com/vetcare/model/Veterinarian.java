/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetcare.model;

/**
 *
 * @author davidcarrascal
 */
public class Veterinarian {
    private int id;
    private String documentNumber;
    private String name;
    private String licenseNumber;
    private String specialty;
    private String phone;
    private String email;
    private boolean active;

    public int getId() {
        return id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }
    
    
    // SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}

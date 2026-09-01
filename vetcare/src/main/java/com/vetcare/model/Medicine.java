/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetcare.model;

import java.time.LocalDate;

/**
 *
 * @author davidcarrascal
 */
public class Medicine {
    private int id;
    private String code;
    private String name;
    private String presentation;
    private String laboratoty;
    private int availableQuantity;
    private int minimumQuantity;
    private double unitPrice;
    private boolean active;
    private LocalDate registeredDate;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPresentation() {
        return presentation;
    }

    public String getLaboratoty() {
        return laboratoty;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }
    
    // SETTERS 

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setLaboratoty(String laboratoty) {
        this.laboratoty = laboratoty;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
    
    
   
}

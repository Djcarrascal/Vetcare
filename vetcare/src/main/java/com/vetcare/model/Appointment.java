/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetcare.model;

import java.time.LocalDate;
import java.time.LocalTime;
import com.vetcare.enums.AppointmentStatus;

/**
 *
 * @author davidcarrascal
 */
public class Appointment {
    private int id;
    private Pet pet;
    private Veterinarian veterinarian;
    private LocalDate date;
    private LocalTime time;
    private String reason;
    private AppointmentStatus appointmentStatus;
    private LocalDate createDate;

    public int getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
    
    // SETTERS 

    public void setId(int id) {
        this.id = id;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    
    
}

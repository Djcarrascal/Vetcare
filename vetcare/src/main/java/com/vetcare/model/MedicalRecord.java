/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetcare.model;
import java.time.LocalDate;
import com.vetcare.enums.AppointmentStatus;

/**
 *
 * @author davidcarrascal
 */
public class MedicalRecord {
    private int id;
    private Appointment appointent;
    private Pet pet;
    private Veterinarian veterinarian;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String observations;
    private LocalDate attendedDate;
    private AppointmentStatus appointmentStatus;

    public int getId() {
        return id;
    }

    public Appointment getAppointent() {
        return appointent;
    }

    public Pet getPet() {
        return pet;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getObservations() {
        return observations;
    }

    public LocalDate getAttendedDate() {
        return attendedDate;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }
    
    
   // SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setAppointent(Appointment appointent) {
        this.appointent = appointent;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setAttendedDate(LocalDate attendedDate) {
        this.attendedDate = attendedDate;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
    
    
    
    
}

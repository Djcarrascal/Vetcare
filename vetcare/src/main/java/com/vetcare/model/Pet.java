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
public class Pet {
    private int id;
    private String name;
    private Owner owner;
    private String species;
    private String breed;
    private String sex;
    private LocalDate birthDate;
    private double weight;
    private boolean active;
    private LocalDate registeredDate;

    
    // se crean los getters y setters
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public String getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    
    // Aquí empiezan los Setters 
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
    
    
   
}

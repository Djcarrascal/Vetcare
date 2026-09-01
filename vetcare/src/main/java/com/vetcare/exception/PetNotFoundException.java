/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.vetcare.exception;

/**
 *
 * @author davidcarrascal
 */
public class PetNotFoundException extends BusinessException {
    public PetNotFoundException(String message) {
        super(message);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.vetcare.exception;

/**
 *
 * @author davidcarrascal
 */
public class InsufficientStockException extends BusinessException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
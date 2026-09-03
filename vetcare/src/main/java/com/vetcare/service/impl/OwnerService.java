/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vetcare.service.impl;

import com.vetcare.exception.BusinessException;
import com.vetcare.exception.OwnerNotFoundException;
import com.vetcare.model.Owner;
import java.util.List;

/**
 *
 * @author davidcarrascal
 */
public interface OwnerService {
    // Registra un propietario aplicando todas las validaciones del negocio
    Owner registerOwner(Owner owner) throws BusinessException;
    
    // Busca un propietario por Id o lanza exepción del negocio si no lo encuentra;
    Owner getOwnerById(Long id) throws OwnerNotFoundException;
    
    // Retorna todos los dueños activos
    List<Owner> getAllOwners();
    
    // Actualiza los datos de un dueño existente con validaciones
    void updateOwner (Owner owner) throws BusinessException;
    
    // Desactiva la cuenta de un propietario 
    void deactivateOwner(Long id) throws OwnerNotFoundException;
}

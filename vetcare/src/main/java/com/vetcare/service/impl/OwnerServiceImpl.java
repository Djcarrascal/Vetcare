/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetcare.service.impl;

import com.vetcare.exception.BusinessException;
import com.vetcare.exception.DuplicateOwnerDocumentException;
import com.vetcare.exception.OwnerNotFoundException;
import com.vetcare.model.Owner;
import com.vetcare.repository.OwnerRepository;
import java.util.Date;

import java.util.List;

/**
 *
 * @author davidcarrascal
 */
public class OwnerServiceImpl implements OwnerService {
    // Aqui declaramos la dependencia hacia la interfaz, no a la clase JDBC.

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner registerOwner(Owner owner) throws BusinessException {
        // Aqui hacemos la validacion 1: Campos obligatorios
        validateRequiredFields(owner);
        //Aquí hacemos la segunda Validación: Documento Único, no puede estar repetido.
        if (ownerRepository.findByIdentificationNumber(owner.getIdentificationNumber()).isPresent()) {
            throw new DuplicateOwnerDocumentException("Ya existe un propietario con este número de documento");
        }

        // Asignamos valores por defecto antes de guardar
        owner.setState(true); //activo
        owner.setRegisteredDate(new java.sql.Date(System.currentTimeMillis())); //Fecha de registro actual

        //Si todo está correcto, delegamos el guardado al repositorio
        return ownerRepository.save(owner);
    }

    @Override
    public Owner getOwnerById(Long id) throws OwnerNotFoundException {
        // Si el Optional está vacío, lanzamos nuestra excepción personalizada
        return ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException("No se encontró ningún propietario con el ID: " + id));
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public void updateOwner(Owner owner) throws BusinessException {
        if (owner.getId() == null) {
            throw new BusinessException("El ID del propietario es obligatorio para actualizar.");
        }

        // Verificamos que el dueño exista antes de actualizar
        getOwnerById(owner.getId());

        // Validamos campos requeridos
        validateRequiredFields(owner);

        ownerRepository.update(owner);
    }

    @Override
    public void deactivateOwner(Long id) throws OwnerNotFoundException {
        // Validamos primero que el dueño exista
        getOwnerById(id);

        // Ejecutamos la desactivación lógica
        ownerRepository.deactivate(id);
    }

    /*
     Método auxiliar para validar que los campos esenciales no lleguen nulos
     ni vacíos.
     */
    private void validateRequiredFields(Owner owner) throws BusinessException {
        if (owner == null) {
            throw new BusinessException("Los datos del propietario no pueden ser nulos.");
        }
        if (owner.getFullname() == null || owner.getFullname().trim().isEmpty()) {
            throw new BusinessException("El nombre completo es obligatorio.");
        }
        if (owner.getIdentificationNumber() == null || owner.getIdentificationNumber().trim().isEmpty()) {
            throw new BusinessException("El número de documento es obligatorio.");
        }
        if (owner.getPhone() == null || owner.getPhone().trim().isEmpty()) {
            throw new BusinessException("El teléfono es obligatorio.");
        }
    }

}

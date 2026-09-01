/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vetcare.repository;

import com.vetcare.model.Owner;
import java.util.List;
import java.util.Optional;

/*/**
* Interfaz que define las operaciones permitidas sobre la entidad Owner.
* Sirve como contrato para desacoplar la lógica del negocio del acceso a la BD.
*/
public interface OwnerRepository {

    // Guarda un nuevo propietario y debe devolverlo con su ID asignado
    Owner save(Owner owner);

    // Busca un propietario por su ID; Optional maneja de forma segura si no existe
    Optional<Owner> findById(Long id);

    // Retorna la lista de todos los propietarios activos
    List<Owner> findAll();

    // Actualiza los datos de un propietario existente
    void update(Owner owner);

    // Realiza un borrado lógico (cambia el estado a inactivo en vez de borrar la fila)
    void deactivate(Long id);

    // Busca por número de identificación único (cédula, DNI, etc.)
    Optional<Owner> findByIdentificationNumber(String identificationNumber);
}


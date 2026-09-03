/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vetcare.repository.impl;

import com.vetcare.config.ConnectionFactory;
import com.vetcare.model.Owner;
import com.vetcare.repository.OwnerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerRepositoryJdbc implements OwnerRepository {

    @Override
    public Owner save(Owner owner) {
        // Consulta SQL con comodines (?) para evitar inyecciones SQL
        String sql = "INSERT INTO owners (identification_type, document_number, full_name, phone, email, addres, state, registered_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // try-with-resources: Abre y asegura el cierre automático de la conexión y el statement.
        // Statement.RETURN_GENERATED_KEYS solicita a MySQL el ID auto-incremental generado.
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Asignamos los valores a cada '?' según su posición (iniciando en 1)
            ps.setString(1, owner.getIdentificationType());
            ps.setString(2, owner.getIdentificationNumber());
            ps.setString(3, owner.getFullname());
            ps.setString(4, owner.getPhone());
            ps.setString(5, owner.getEmail());
            ps.setString(6, owner.getAddress());
            ps.setBoolean(7, true); // Todo nuevo registro entra activo por defecto
            ps.setDate(8, owner.getRegisteredDate());

            // Ejecuta la inserción en la base de datos
            ps.executeUpdate();

            // Obtenemos la clave autogenerada (el ID autoincremental de la fila)
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Le asignamos ese ID numérico generado a nuestro objeto Java
                    owner.setId((Long) generatedKeys.getLong(1));
                }
            }

            return owner;

        } catch (SQLException e) {
            // Empaquetamos el error SQL en una excepción no comprobada para no ensuciar la firma del método
            throw new RuntimeException("Error al guardar el propietario en la base de datos", e);
        }
    }

    @Override
    public Optional<Owner> findById(Long id) {
        String sql = "SELECT * FROM owners WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            // Asignamos el ID al parámetro de búsqueda
            ps.setLong(1, id);

            // executeQuery() se usa para consultas SELECT y devuelve un ResultSet (tabla de resultados)
            try (ResultSet rs = ps.executeQuery()) {
                // Si rs.next() es true, significa que encontró al menos una fila
                if (rs.next()) {
                    return Optional.of(mapResultSetToOwner(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar propietario con ID: " + id, e);
        }

        // Si no encontró nada, retornamos un Optional vacío para evitar null
        return Optional.empty();
    }

    @Override
    public List<Owner> findAll() {
        List<Owner> owners = new ArrayList<>();
        // Filtramos solo los registros que no han sido desactivados
        String sql = "SELECT * FROM owners WHERE state = true";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            // Recorremos fila por fila mientras haya registros disponibles
            while (rs.next()) {
                // Convertimos la fila actual en objeto Owner y lo añadimos a la lista
                owners.add(mapResultSetToOwner(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la lista de propietarios", e);
        }

        return owners;
    }

    @Override
    public void update(Owner owner) {
        String sql = "UPDATE owners SET name = ?, email = ?, phone = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            // Reemplazamos los datos actualizados
            ps.setString(1, owner.getIdentificationType());
            ps.setString(2, owner.getIdentificationNumber());
            ps.setString(3, owner.getFullname());
            ps.setString(4, owner.getPhone());
            ps.setString(5, owner.getEmail());
            ps.setString(6, owner.getAddress());
            ps.setBoolean(7, true);
            ps.setDate(8, owner.getRegisteredDate()); // La condición WHERE para saber a quién actualizar

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar los datos del propietario", e);
        }
    }

    @Override
    public void deactivate(Long id) {
        // En lugar de hacer DELETE (que puede romper integridad referencial), cambiamos el flag a false
        String sql = "UPDATE owners SET state = false WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al desactivar el propietario con ID: " + id, e);
        }
    }

    @Override
    public Optional<Owner> findByIdentificationNumber(String identificationNumber) {
        String sql = "SELECT * FROM owners WHERE document_number = ?";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificationNumber);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToOwner(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar por documento de identificación");
        }

        return Optional.empty();
    }

    /*    /**
    * Método auxiliar privado (Helper). Mapea las columnas de la tabla 'owners'
    * a un objeto de la entidad Owner.
     */
    private Owner mapResultSetToOwner(ResultSet rs) throws SQLException {
        Owner owner = new Owner();

        owner.setId((Long) rs.getLong("id"));
        owner.setIdentificationType(rs.getString("identification_type")); // Si usas Enum: IdentificationType.valueOf(rs.getString("identification_type"))
        owner.setDocumentNumber(rs.getString("document_number"));
        owner.setFullName(rs.getString("full_name"));
        owner.setPhone(rs.getString("phone"));
        owner.setEmail(rs.getString("email"));
        owner.setAddress(rs.getString("addres"));
        owner.setState(rs.getBoolean("state"));
        owner.setRegisteredDate(rs.getDate("registered_date"));
        return owner;
    }
}

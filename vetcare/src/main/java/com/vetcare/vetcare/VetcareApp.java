package com.vetcare.vetcare;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import com.vetcare.config.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class VetcareApp {
    public static void main(String[] args) {
        // Usamos try-with-resources para asegurar que la conexión se cierre al terminar la prueba
        try (Connection conn = ConnectionFactory.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Conexión exitosa");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos:");
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Código de error: " + e.getErrorCode());
            e.printStackTrace();
        }
    }
}

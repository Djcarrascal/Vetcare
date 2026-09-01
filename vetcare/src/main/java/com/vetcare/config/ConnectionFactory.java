/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetcare.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author davidcarrascal
 */
public class ConnectionFactory {

    // Constantes de configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/db_vetcare";
    private static final String USER = "root";       
    private static final String PASSWORD = "";       

    // Constructor privado para evitar instanciación directa
    private ConnectionFactory() {}

    /**
     * Obtiene y retorna una conexión activa a la base de datos MySQL.
     * @return Connection objeto de conexión JDBC
     * @throws SQLException si ocurre un error al conectar
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

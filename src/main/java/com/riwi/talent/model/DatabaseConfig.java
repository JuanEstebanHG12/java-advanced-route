package com.riwi.talent.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TASK 1: Gestión de conexiones.
 */
public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/talent_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /*
       EXPLICACIÓN LEGACY (Java 7 e inferiores):
       Antes de Java 7, las conexiones debían cerrarse manualmente en un bloque 'finally':
       
       Connection conn = null;
       try {
           conn = getConnection();
           // usar la conexión
       } catch (SQLException e) { ... }
       finally {
           if (conn != null) conn.close(); // Esto era propenso a errores y fugas de memoria
       }

       SINTAXIS MODERNA (Try-with-resources):
       Ahora usamos try(Connection conn = ...) { }. Java garantiza el cierre automático 
       al finalizar el bloque, evitando los Memory Leaks (fugas de memoria) de forma segura.
    */
}

package com.riwi.talent.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAOImpl {

    // Método para insertar usando try-with-resources
    public void insertar(EmpleadoReport emp) {
        String sql = "INSERT INTO empleados (nombre, cargo, salario) VALUES (?, ?, ?)";
        
        // try-with-resources cierra automáticamente la conexión y el statement
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, emp.nombre());
            ps.setString(2, emp.cargo());
            ps.setDouble(3, emp.salario());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    public List<EmpleadoReport> listarTodos() {
        List<EmpleadoReport> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Mapeamos de la BD al Record directamente
                lista.add(new EmpleadoReport(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("cargo"),
                    rs.getDouble("salario")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}

package com.riwi.talent.controller;

import com.riwi.talent.model.EmpleadoDAOImpl;
import com.riwi.talent.model.EmpleadoReport;
import com.riwi.talent.view.MainView;

import java.util.List;


public class EmpleadoController {
    private EmpleadoDAOImpl dao;
    private MainView vista;

    public EmpleadoController(EmpleadoDAOImpl dao, MainView vista) {
        this.dao = dao;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> agregarEmpleado();
                case 2 -> listarEmpleados();
                case 3 -> eliminarEmpleado();
                case 4 -> generarReporte();
            }
        } while (opcion != 5);
    }

    private void agregarEmpleado() {
        String nombre = vista.leerTexto("Nombre: ");
        String cargo = vista.leerTexto("Cargo: ");
        double salario = vista.leerDecimal("Salario: ");
        
        dao.insertar(new EmpleadoReport(0, nombre, cargo, salario));
        vista.mostrarMensaje("¡Empleado guardado exitosamente!");
    }

    private void listarEmpleados() {
        List<EmpleadoReport> lista = dao.listarTodos();
        vista.mostrarMensaje("\n--- Lista de Empleados ---");
        lista.forEach(e -> vista.mostrarMensaje(e.toString()));
    }

    private void eliminarEmpleado() {
        int id = vista.leerEntero("ID del empleado a eliminar: ");
        dao.eliminar(id);
        vista.mostrarMensaje("Empleado eliminado.");
    }

    private void generarReporte() {
        List<EmpleadoReport> lista = dao.listarTodos();
        int total = lista.size();
        
        // Text Block (Java 15+)
        String reporteHead = """
            ******************************************
            *       REPORTE DE TALENTO HUMANO        *
            ******************************************
            """;
        
        vista.mostrarMensaje(reporteHead);
        vista.mostrarMensaje("Total empleados en BD: " + total);
        vista.mostrarMensaje("******************************************");
    }
}

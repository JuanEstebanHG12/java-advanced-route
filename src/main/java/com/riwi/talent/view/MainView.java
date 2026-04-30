package com.riwi.talent.view;

import java.util.Scanner;

public class MainView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("""
            
            --- GESTIÓN DE TALENTO RIWI ---
            1. Agregar Empleado
            2. Listar Empleados
            3. Eliminar Empleado
            4. Generar Reporte Final
            5. Salir
            Seleccione una opción: """);
        return scanner.nextInt();
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine(); // Limpiar buffer
        return scanner.nextLine();
    }

    public double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

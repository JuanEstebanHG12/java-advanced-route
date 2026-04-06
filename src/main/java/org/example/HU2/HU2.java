package org.example.HU2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HU2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        // TASK 2: Bucle para mantener el sistema activo
        do {
            // TASK 1: Menú principal con Switch Legacy (Java 8)
            System.out.println("\n--- SISTEMA JUPITER - GESTIÓN DE EMPLEADOS ---");
            System.out.println("1. Registrar y Procesar Desempeño");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = teclado.nextInt();

                /* Comparativa: En este switch tradicional de Java 8, es obligatorio
                   usar 'break' en cada caso. Si lo olvidas, el código sigue ejecutando
                   el siguiente caso (riesgo de "fall-through").
                */
                switch (opcion) {
                    case 1:
                        procesarEmpleados(teclado);
                        break;
                    case 2:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                // TASK 4: Manejo de errores para evitar que el programa explote
                System.out.println("Error: Debes ingresar un número entero.");
                teclado.nextLine(); // Limpiar el buffer del scanner
                opcion = 0;
            }

        } while (opcion != 2);
    }

    public static void procesarEmpleados(Scanner sc) {
        // TASK 2: Uso de 'var' para inferencia de tipos (Java 11+)
        System.out.print("¿Cuántos empleados desea procesar?: ");
        var numEmpleados = sc.nextInt();

        // TASK 3: Matriz para 3 trimestres por cada empleado
        double[][] calificaciones = new double[numEmpleados][3];

        for (var i = 0; i < numEmpleados; i++) {
            System.out.println("\nRegistro para Empleado #" + (i + 1));
            var suma = 0.0;

            for (var j = 0; j < 3; j++) {
                System.out.print("Nota Trimestre " + (j + 1) + " (0-10): ");

                // TASK 4: Try-Catch para capturar errores de entrada
                try {
                    var nota = sc.nextDouble();

                    // Validación de rangos (Task 2)
                    if (nota >= 0 && nota <= 10) {
                        calificaciones[i][j] = nota;
                        suma += nota;
                    } else {
                        System.out.println("Nota fuera de rango. Se asigna 0.");
                        calificaciones[i][j] = 0;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Se asigna 0.");
                    sc.nextLine();
                    calificaciones[i][j] = 0;
                }
            }

            double promedio = suma / 3;

            // TASK 3: Casting explícito (de double a int)
            int puntajeSimplificado = (int) promedio;

            // TASK 4: Operador Ternario para promoción
            String estado = (promedio >= 7.0) ? "PROMOCIONADO" : "EN OBSERVACIÓN";

            System.out.println("Promedio: " + promedio + " | Puntaje: " + puntajeSimplificado);
            System.out.println("Estado: " + estado);

            // TASK 1: Llamada a Switch Moderno
            System.out.println("Categoría: " + obtenerCategoriaSalarial(puntajeSimplificado));
        }
    }

    // TASK 1: Switch Expression Moderna (Java 17/21)
    public static String obtenerCategoriaSalarial(int puntaje) {
        /*
           Comparativa: La sintaxis de flecha (->) es mucho más segura y breve.
           No necesita 'break', no hay riesgo de fall-through y devuelve un valor directamente.
        */
        return switch (puntaje) {
            case 10, 9 -> "Sueldo Senior";
            case 8, 7 -> "Sueldo Semi-Senior";
            case 6, 5 -> "Sueldo Junior";
            default -> "Sueldo Base";
        };
    }
}
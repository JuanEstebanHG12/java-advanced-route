package org.example.retos.semana2.DiaDos;

import java.util.Scanner;

public class DiaDos {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                    === MENÚ ===
                    1. Registrar usuario
                    2. Calcular promedio
                    0. Salir
                    """);
            System.out.print("Elige una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    // Uso de var (mínimo 5 variables)
                    System.out.print("ID (1-1000): ");
                    var id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");
                    var nombre = sc.nextLine();

                    System.out.print("Edad (0-120): ");
                    var edad = Integer.parseInt(sc.nextLine());

                    System.out.print("Altura en cm (0 - 250): ");
                    var altura = Double.parseDouble(sc.nextLine());


                    // Validaciones
                    if (id < 1 || id > 1000) {
                        System.out.println("ID fuera de rango");
                    } else if (edad < 0 || edad > 120) {
                        System.out.println("Edad inválida");
                    } else if (altura < 0 || altura > 250) {
                        System.out.println("Altura fuera de rango");
                    } else {
                        System.out.println("Usuario registrado:");
                        System.out.println("ID: " + id);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Edad: " + edad);
                        System.out.println("Altura: " + altura);
                    }
                    break;

                case 2:
                    System.out.print("Nota 1 (0-5): ");
                    var n1 = Double.parseDouble(sc.nextLine());

                    System.out.print("Nota 2 (0-5): ");
                    var n2 = Double.parseDouble(sc.nextLine());

                    System.out.print("Nota 3 (0-5): ");
                    var n3 = Double.parseDouble(sc.nextLine());

                    // Validación
                    if (n1 < 0 || n1 > 5 || n2 < 0 || n2 > 5 || n3 < 0 || n3 > 5) {
                        System.out.println("Notas inválidas");
                    } else {
                        var promedio = (n1 + n2 + n3) / 3;
                        System.out.println("Promedio: " + promedio);
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

    }
}

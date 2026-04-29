package org.example.HU3;

import java.util.*;

public class HU3 {
    public static void main(String[] args) {
        System.out.println("=== Evolución de Colecciones: De Java 8 a Java 21 ===\n");

        // TASK 1: Migración a ArrayList y HashMap (Legacy 8/11)
        // El ArrayList permite guardar elementos de forma dinámica (sin tamaño fijo).
        List<Empleado> listaEmpleados = new ArrayList<>();
        
        // El HashMap permite búsquedas instantáneas usando una clave única (ID).
        // En lugar de recorrer toda la lista, buscamos directamente por el ID.
        Map<String, Empleado> mapaEmpleados = new HashMap<>();

        // Agregamos algunos empleados de ejemplo
        Empleado emp1 = new Empleado("C001", "Ana", 3000, 85);
        Empleado emp2 = new Empleado("C002", "Beto", 2500, 60); // Este será filtrado luego
        Empleado emp3 = new Empleado("C003", "Carla", 4000, 95);

        listaEmpleados.add(emp1);
        listaEmpleados.add(emp2);
        listaEmpleados.add(emp3);

        // Los guardamos también en el mapa para acceso rápido
        mapaEmpleados.put(emp1.getId(), emp1);
        mapaEmpleados.put(emp2.getId(), emp2);
        mapaEmpleados.put(emp3.getId(), emp3);

        // TASK 2: Inicialización y Factory Methods (Legacy 9/11)

        // List.of() y Map.of() crean colecciones INMUTABLES (no se pueden modificar).
        List<String> tecnologias = List.of("Java", "Spring", "SQL");
        Map<String, String> sedes = Map.of("S01", "Medellín", "S02", "Bogotá");


        // Sintaxis Legacy (Java 8/11): Requiere índices manuales y conocer el tamaño.
        Empleado primeroLegacy = listaEmpleados.get(0);
        Empleado ultimoLegacy = listaEmpleados.get(listaEmpleados.size() - 1);
        System.out.println("[Legacy] Primero: " + primeroLegacy.getNombre() + " | Último: " + ultimoLegacy.getNombre());

        // Sintaxis Moderna (Java 21): Nuevos métodos más naturales y legibles.
        Empleado primeroJava21 = listaEmpleados.getFirst(); 
        Empleado ultimoJava21 = listaEmpleados.getLast();
        List<Empleado> listaInversa = listaEmpleados.reversed(); // ¡Orden inverso sin algoritmos manuales!

        System.out.println("[Java 21] Primero: " + primeroJava21.getNombre() + " | Último: " + ultimoJava21.getNombre());


        // TASK 4: Filtrado avanzado y Tipado con 'var'

        System.out.println("\n--- Aplicando filtros y Reporte Final ---");

        // removeIf (Java 8+): Elimina empleados con puntaje menor a 70.
        // Es mucho más eficiente que un bucle for tradicional para borrar elementos.
        listaEmpleados.removeIf(emp -> emp.getPuntaje() < 70);

        // Inferencia de tipos con 'var' (Java 11+): 
        // Simplifica la declaración. El compilador ya sabe que es un Empleado o un Double.
        double sumaSalarios = 0;
        for (var e : listaEmpleados) {
            System.out.println("Empleado activo: " + e);
            sumaSalarios += e.getSalario();
        }

        var total = listaEmpleados.size();
        var promedio = (total > 0) ? (sumaSalarios / total) : 0;

        System.out.println("\n================ REPORT REPORT ================");
        System.out.println("Total de empleados (post-filtrado): " + total);
        System.out.println("Promedio de salarios: $" + String.format("%.2f", promedio));
        System.out.println("===============================================");
    }
}

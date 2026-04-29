package org.example.HU4;

import java.util.List;

public class HU4 {
    public static void main(String[] args) {
        System.out.println("=== Jerarquía Protegida y Modelado Moderno (POO Java 21) ===\n");

        // Creamos una lista de Personas (Polimorfismo en acción)
        List<Persona> equipo = List.of(
            new Desarrollador(1, "Ana", 5000, "Java"),
            new Gerente(2, "Beto", 8000, 150000),
            new ConsultorExterno(3, "Carla")
        );

        for (Persona p : equipo) {
            System.out.println("Analizando: " + p.getNombre() + " (" + p.getTipo() + ")");
            
            // TASK 3: Pattern Matching for instanceof (Java 17+)

            // Estilo Legacy (Java 8/11): Requiere dos pasos (verificar + convertir)
            if (p instanceof Desarrollador) {
                Desarrollador dLegacy = (Desarrollador) p; // Casting manual ruidoso
                System.out.println("  [Legacy] Casting manual para ver lenguaje: " + dLegacy.getLenguajePrincipal());
            }

            // Estilo Moderno (Java 17+): Pattern Matching
            // Verifica y crea la variable 'dev' en un solo paso. ¡Mucho más limpio!
            if (p instanceof Desarrollador dev) {
                System.out.println("  [Moderno] Lenguaje detectado: " + dev.getLenguajePrincipal());
            } else if (p instanceof Gerente ger) {
                System.out.println("  [Moderno] Presupuesto asignado: $" + ger.getPresupuestoMensual());
            }

            // TASK 4: Polimorfismo e Interfaces (Método Default)
            if (p instanceof Empleado emp) {
                double bono = emp.calcularBonoAscenso();
                emp.registrarLog("Bono por ascenso calculado: $" + bono);
            }
            
            System.out.println("--------------------------------------------------");
        }

        // TASK 2: Modelado Inmutable con Records
        System.out.println("\n--- Reporte Final de Mes (Inmutabilidad con Records) ---");
        
        // Creamos el record. No tuvimos que escribir getters ni constructor.
        DesempeñoReport reporte = new DesempeñoReport(101, 4.9, "Liderazgo excepcional en HU4");
        
        System.out.println("Datos del Record: " + reporte); // toString() automático
        System.out.println("Acceso directo al feedback: " + reporte.feedback());

    }
}
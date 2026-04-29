package org.example.HU3;

public class Empleado {
    private String id;
    private String nombre;
    private double salario;
    private int puntaje; // Campo necesario para el filtrado de la TASK 4

    public Empleado(String id, String nombre, double salario, int puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.puntaje = puntaje;
    }

    // Getters (necesarios para acceder a los datos)
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }
    public int getPuntaje() { return puntaje; }

    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %-10s | Salario: $%.2f | Puntaje: %d", 
                id, nombre, salario, puntaje);
    }
}

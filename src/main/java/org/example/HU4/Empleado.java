package org.example.HU4;

public non-sealed class Empleado extends Persona implements Promocionable {
    protected double salarioBase;

    public Empleado(int id, String nombre, double salarioBase) {
        super(id, nombre);
        this.salarioBase = salarioBase;
    }

    @Override
    public String getTipo() {
        return "Empleado";
    }

    @Override
    public double calcularBonoAscenso() {
        return salarioBase * 0.10; // Bono base del 10%
    }
}

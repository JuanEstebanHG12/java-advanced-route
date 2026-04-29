package org.example.HU4;

public class Gerente extends Empleado {
    private double presupuestoMensual;

    public Gerente(int id, String nombre, double salario, double presupuesto) {
        super(id, nombre, salario);
        this.presupuestoMensual = presupuesto;
    }

    public double getPresupuestoMensual() {
        return presupuestoMensual;
    }

    @Override
    public String getTipo() {
        return "Gerente de Proyecto";
    }
}

package org.example.HU4;

public class Desarrollador extends Empleado {
    private String lenguajePrincipal;

    public Desarrollador(int id, String nombre, double salario, String lenguaje) {
        super(id, nombre, salario);
        this.lenguajePrincipal = lenguaje;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    @Override
    public String getTipo() {
        return "Desarrollador (" + lenguajePrincipal + ")";
    }
}

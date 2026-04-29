package org.example.HU4;


public abstract sealed class Persona permits Empleado, ConsultorExterno {
    // TASK 4: Encapsulamiento con 'protected' para que las subclases accedan
    protected int id;
    protected String nombre;

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public abstract String getTipo();

    public String getNombre() { return nombre; }
    public int getId() { return id; }
}

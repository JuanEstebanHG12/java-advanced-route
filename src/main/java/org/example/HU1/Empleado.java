package org.example.HU1;

//Clas with Java 8
// ==============================
// Clase tradicional (Java 8)
// ==============================
public class Empleado {
    // Tipos primitivos
    byte edadByte;
    short antiguedadShort;
    int idInt;
    long salarioLong;
    float bonusFloat;
    double salarioDouble;
    char generoChar;
    boolean esRemoto;

    // Tipo de referencia
    String nombre;

    // Constructor
    public Empleado(byte edadByte, short antiguedadShort, int idInt, long salarioLong,
                    float bonusFloat, double salarioDouble, char generoChar, boolean esRemoto,
                    String nombre) {
        this.edadByte = edadByte;
        this.antiguedadShort = antiguedadShort;
        this.idInt = idInt;
        this.salarioLong = salarioLong;
        this.bonusFloat = bonusFloat;
        this.salarioDouble = salarioDouble;
        this.generoChar = generoChar;
        this.esRemoto = esRemoto;
        this.nombre = nombre;
    }

    /*
     * Método que calcula el salario final aplicando reglas de negocio.
     * Orden de ejecución:
     * 1. Paréntesis internos
     *    - (bonoMensual * 1.10)
     *    - (salarioBase * 0.05)
     * 2. Suma:
     *    - salarioBase + resultado del bono incrementado
     * 3. Resta:
     *    - resultado anterior - descuento
     */
    public double calcularSalarioFinal() {
        if (tieneBonoExtra()){
            return (salarioLong + (bonusFloat * 1.12)) - (salarioLong * 0.05);
        }
        return (salarioLong + (bonusFloat * 1.10)) - (salarioLong * 0.05);
    }


    /*
     * Determina si el empleado tiene un bono extra usando operador módulo (%)
     * Si el ID es par, obtiene beneficio adicional
     */
    public boolean tieneBonoExtra() {
        return (idInt % 2 == 0);
    }


    // Getters with classes(muy verbosos)
    public String getNombre() { return nombre; }
    public int getIdInt() { return idInt; }
    public boolean isEsRemoto() { return esRemoto; }

    @Override
    public String toString() {
        return String.format("""
                Empleado -> %s
                Id -> %d
                Salario -> %d
                Trabaja remoto -> %b
                """, nombre ,idInt, salarioLong, esRemoto
        );
//        return "Empleado{" +
//                "nombre='" + nombre + '\'' +
//                ", idInt=" + idInt +
//                ", Salario=" + salarioLong +
//                ", esRemoto=" + esRemoto +
//                '}';
    }
}

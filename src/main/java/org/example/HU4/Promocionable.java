package org.example.HU4;

public interface Promocionable {
    // Método abstracto que debe ser implementado
    double calcularBonoAscenso();

    default void registrarLog(String mensaje) {
        System.out.println("[LOG SISTEMA]: Operación realizada -> " + mensaje);
    }
}

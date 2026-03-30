package org.example.retos.semana2.DiaUno;

public class Switch {
    public static String obtenerCategoriaSalarial(Double salario) {

        return switch (salario){
            case Double s when s <= 400 -> "Junior";
            case Double s when s <= 600 -> "Senior";
            case Double s when s <= 800 -> "Expert";
            default -> "Este salario no se encuentra en el rango";
        };
    }
}

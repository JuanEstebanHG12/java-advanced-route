package org.example.retos.semana2;


import org.example.retos.semana2.DiaUno.Switch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);

        //menú
        System.out.println("""
                1.Obtener Categoria Salarial
                0.Salir
                """);
        //leer opción
        do{
            System.out.println("Ingresa una opcion");
            option = sc.nextInt();
        }while (option < 0 || option > 1 );

        //switch que usa el caso según opción
        switch (option){
            case 1: // calcular salario
                Double salario;
                do{
                    System.out.println("Ingresa el salario");
                    salario = sc.nextDouble();
                }while (salario <= 0 );
                System.out.println(Switch.obtenerCategoriaSalarial(salario));
                break;
            case 0: break; // salir del programa
        }

        sc.close();
    }
}

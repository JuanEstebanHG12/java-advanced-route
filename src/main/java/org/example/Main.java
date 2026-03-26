package org.example;

import org.example.HU1.Empleado;
import org.example.HU1.EmpresaRecord;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // ==============================
        // Ejemplo de uso de la clase tradicional
        // ==============================
        Empleado emp = new Empleado((byte)25, (short)2, 101, 50000L,
                1500.5f, 52000.75, 'M', true, "Juan Pérez");
        System.out.println(emp);
        //Use getter from class
        System.out.println(emp.getNombre());

        // ==============================
        // Ejemplo de uso del record moderno
        // ==============================
        EmpresaRecord empresa = new EmpresaRecord("Tech Solutions", "900123456", 2010);
        System.out.println(empresa);
    }
}
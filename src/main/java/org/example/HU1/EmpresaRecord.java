package org.example.HU1;

// ==============================
// Record moderno (Java 17/21)
// ==============================
public record EmpresaRecord(String nombre, String nit, int anioFundacion) {
    //Constructor
    //Here, properties are created automatically.
    //Getters (with the same name as the field)
}

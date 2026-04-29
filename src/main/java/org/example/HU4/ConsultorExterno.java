package org.example.HU4;


public final class ConsultorExterno extends Persona {
    public ConsultorExterno(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public String getTipo() {
        return "Consultor Externo (Por contrato)";
    }
}

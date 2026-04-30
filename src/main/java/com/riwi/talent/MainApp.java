package com.riwi.talent;

import com.riwi.talent.controller.EmpleadoController;
import com.riwi.talent.model.EmpleadoDAOImpl;
import com.riwi.talent.view.MainView;

public class MainApp {
    public static void main(String[] args) {
        // 1. Inicializamos el Modelo (DAO)
        EmpleadoDAOImpl model = new EmpleadoDAOImpl();
        
        // 2. Inicializamos la Vista
        MainView view = new MainView();
        
        // 3. Inicializamos el Controlador y le pasamos el Modelo y la Vista
        EmpleadoController controller = new EmpleadoController(model, view);

        // 4. Arrancamos la aplicación
        controller.iniciar();
    }
}

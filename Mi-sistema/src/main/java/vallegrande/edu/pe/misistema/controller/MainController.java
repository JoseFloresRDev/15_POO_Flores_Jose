package vallegrande.edu.pe.misistema.controller;

import vallegrande.edu.pe.misistema.view.MainView;

public class MainController {

    private MainView view;

    public MainController(MainView view) {
        this.view = view;
        configurarEventos();
    }

    private void configurarEventos() {

        // INICIO
        view.getBtnInicio().setOnAction(e -> {
            view.mostrarInicio();
        });

        // USUARIOS
        view.getBtnUsuarios().setOnAction(e -> {
            view.mostrarUsuarios();
        });

        // PRODUCTOS
        view.getBtnProductos().setOnAction(e -> {
            view.mostrarProductos();
        });

        // REPORTES
        view.getBtnReportes().setOnAction(e -> {
            view.mostrarReportes();
        });

        // VENTAS
        view.getBtnVentas().setOnAction(e -> {
            view.mostrarVentas();
        });

        // CONFIGURACIÓN
        view.getBtnConfiguracion().setOnAction(e -> {
            view.mostrarConfiguracion();
        });
    }
}
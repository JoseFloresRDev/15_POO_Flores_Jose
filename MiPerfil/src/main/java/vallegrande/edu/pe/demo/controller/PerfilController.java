package vallegrande.edu.pe.demo.controller;

import vallegrande.edu.pe.demo.model.Perfil;
import vallegrande.edu.pe.demo.view.PerfilView;

public class PerfilController {

    private PerfilView view;

    public PerfilController(PerfilView view) {
        this.view = view;

        view.getBtnMostrar().setOnAction(e -> mostrarPerfil());
        view.getBtnLimpiar().setOnAction(e -> limpiarFormulario());
    }

    private void mostrarPerfil() {

        String nombre = view.getTxtNombre().getText();
        String carrera = view.getTxtCarrera().getText();
        String semestre = view.getTxtSemestre().getText();
        String hobby = view.getCmbHobby().getValue();

        if (nombre.trim().isEmpty()) {
            view.getLblResultado().setText("Por favor, ingrese su nombre.");
            return;
        }

        if (carrera.trim().isEmpty()) {
            view.getLblResultado().setText("Por favor, ingrese su carrera.");
            return;
        }

        if (semestre.trim().isEmpty()) {
            view.getLblResultado().setText("Por favor, ingrese su semestre.");
            return;
        }

        if (hobby == null) {
            view.getLblResultado().setText("Por favor, seleccione un hobby.");
            return;
        }


        Perfil perfil = new Perfil(
                nombre,
                carrera,
                semestre,
                hobby
        );

        view.getLblResultado().setText(
                perfil.obtenerPresentacion()
        );
    }

    private void limpiarFormulario() {

        view.getTxtNombre().clear();
        view.getTxtCarrera().clear();
        view.getTxtSemestre().clear();
        view.getCmbHobby().setValue(null);
        view.getLblResultado().setText("");
    }
}
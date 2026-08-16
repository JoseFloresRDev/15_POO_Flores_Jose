package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Revista;

import java.util.ArrayList;

public class RevistaController {

    // Lista donde almacenaremos las revistas
    private ArrayList<Revista> revistas;

    // Constructor
    public RevistaController() {
        revistas = new ArrayList<>();
    }

    // Registrar revista
    public void agregarRevista(Revista revista) {
        revistas.add(revista);
        System.out.println("Revista registrada correctamente");
    }

    // Listar revistas
    public void listarRevistas() {
        if (revistas.isEmpty()) {
            System.out.println("No hay revistas registradas");
            return;
        }

        System.out.println("===== LISTA DE REVISTAS =====");

        for (Revista revista : revistas) {
            revista.mostrarRevista();
        }
    }
}
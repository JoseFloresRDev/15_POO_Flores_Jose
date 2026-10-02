package vallegrande.edu.pe.misistema.controller;

import vallegrande.edu.pe.misistema.model.Usuario;
import vallegrande.edu.pe.misistema.model.UsuarioDAO;
import vallegrande.edu.pe.misistema.view.MainView;

import java.util.List;

public class MainController {

    private MainView view;
    private UsuarioDAO usuarioDAO;

    public MainController(MainView view){
        this.view = view;
        usuarioDAO = new UsuarioDAO();
        configurarEventos();
    }

    public void configurarEventos() {
        view.getBtnInicio().setOnAction(e -> {
            view.mostrarInicio();
        });

        view.getBtnUsuarios().setOnAction(e -> {
            view.mostrarUsuarios();
            cargarUsuarios();
        });

        view.getBtnRegistrar().setOnAction(e -> {
            registrarUsuario();
        });
    }

    private void cargarUsuarios(){
        List<Usuario> usuarios = usuarioDAO.listar();
        view.mostrarDatosUsuarios(usuarios);
    }

    private void registrarUsuario(){
        // Validar que los campos no estén vacíos
        if (view.getNombre().isBlank() ||
                view.getApellido().isBlank() ||
                view.getCorreo().isBlank() ||
                view.getEstado().isBlank()) {

            System.out.println("Por favor, completa todos los campos del formulario.");
            return;
        }

        // Crear la entidad con los datos ingresados
        Usuario usuario = new Usuario();
        usuario.setNombre(view.getNombre());
        usuario.setApellido(view.getApellido());
        usuario.setCorreo(view.getCorreo());
        usuario.setEstado(view.getEstado());

        // Insertar en la base de datos
        usuarioDAO.insertar(usuario);

        // Limpiar el formulario y actualizar la tabla
        view.limpiarFormulario();
        cargarUsuarios();
    }
}
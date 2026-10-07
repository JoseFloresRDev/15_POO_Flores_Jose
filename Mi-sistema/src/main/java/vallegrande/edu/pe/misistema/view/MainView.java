package vallegrande.edu.pe.misistema.view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import vallegrande.edu.pe.misistema.model.Usuario;

public class MainView extends BorderPane {

    // Botones del menú
    private Button btnInicio;
    private Button btnUsuarios;

    // Campos del formulario
    private TextField txtNombre;
    private TextField txtApellido;
    private TextField txtCorreo;
    private TextField txtEstado;

    // Botones de acciones
    private Button btnRegistrar;
    private Button btnActualizar;
    private Button btnEliminar;

    // Tabla donde mostraremos los usuarios
    private TableView<Usuario> tablaUsuarios;

    public MainView() {
        // Creamos el menú
        crearMenu();

        // Creamos la tabla
        crearTabla();

        // Creamos los campos y los botones del formulario
        crearFormulario();

        // Mostramos Inicio al abrir el sistema
        mostrarInicio();
    }

    // Crea el menú lateral
    private void crearMenu() {
        VBox menu = new VBox(15);
        menu.setPadding(new Insets(25));
        menu.setPrefWidth(220);

        Label titulo = new Label("MI SISTEMA");
        titulo.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        btnInicio = crearBoton("Inicio");
        btnUsuarios = crearBoton("Usuarios");

        menu.getChildren().addAll(
                titulo,
                btnInicio,
                btnUsuarios
        );

        menu.setStyle("-fx-background-color: #2563EB;");

        setLeft(menu);
    }

    // Crea un botón del menú
    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setPrefWidth(170);
        boton.setPrefHeight(40);
        return boton;
    }

    // Muestra la pantalla de inicio
    public void mostrarInicio() {
        VBox contenido = new VBox(10);
        contenido.setAlignment(Pos.CENTER);

        Label titulo = new Label("BIENVENIDO");
        titulo.setStyle(
                "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;"
        );

        Label texto = new Label("Sistema de gestión de usuarios");

        contenido.getChildren().addAll(
                titulo,
                texto
        );

        setCenter(contenido);
    }

    // Muestra la pantalla de usuarios
    public void mostrarUsuarios() {
        VBox contenido = new VBox(15);
        contenido.setPadding(new Insets(20));

        Label titulo = new Label("USUARIOS");
        titulo.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-font-weight: bold;"
        );

        // Agrupamos los botones horizontalmente
        HBox contenedorBotones = new HBox(10);
        contenedorBotones.getChildren().addAll(
                btnRegistrar,
                btnActualizar,
                btnEliminar
        );

        // Agregamos el título, inputs, botones y la tabla
        contenido.getChildren().addAll(
                titulo,
                txtNombre,
                txtApellido,
                txtCorreo,
                txtEstado,
                contenedorBotones,
                tablaUsuarios
        );

        setCenter(contenido);
    }

    // Crea los elementos del formulario
    private void crearFormulario() {
        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        txtApellido = new TextField();
        txtApellido.setPromptText("Apellido");

        txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo");

        txtEstado = new TextField();
        txtEstado.setPromptText("Estado");

        btnRegistrar = new Button("Registrar");
        btnActualizar = new Button("Actualizar");
        btnEliminar = new Button("Eliminar");

        // Estilos para los botones
        btnRegistrar.setStyle("-fx-background-color: #16a34a; -fx-text-fill: white;");
        btnActualizar.setStyle("-fx-background-color: #eab308; -fx-text-fill: white;");
        btnEliminar.setStyle("-fx-background-color: #dc2626; -fx-text-fill: white;");
    }

    // Crea la tabla de usuarios
    private void crearTabla() {
        tablaUsuarios = new TableView<>();

        TableColumn<Usuario, Integer> colId = new TableColumn<>("ID");
        TableColumn<Usuario, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Usuario, String> colApellido = new TableColumn<>("Apellido");
        TableColumn<Usuario, String> colCorreo = new TableColumn<>("Correo");
        TableColumn<Usuario, String> colEstado = new TableColumn<>("Estado");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tablaUsuarios.getColumns().addAll(
                colId,
                colNombre,
                colApellido,
                colCorreo,
                colEstado
        );
    }

    // Recibe los usuarios y los muestra en la tabla
    public void mostrarDatosUsuarios(List<Usuario> usuarios) {
        tablaUsuarios.setItems(
                FXCollections.observableArrayList(usuarios)
        );
    }

    // Getters
    public Button getBtnInicio() {
        return btnInicio;
    }

    public Button getBtnUsuarios() {
        return btnUsuarios;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getApellido() {
        return txtApellido.getText();
    }

    public String getCorreo() {
        return txtCorreo.getText();
    }

    public String getEstado() {
        return txtEstado.getText();
    }

    public Button getBtnActualizar() {
        return btnActualizar;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }

    public Usuario getUsuarioSeleccionado() {
        return tablaUsuarios
                .getSelectionModel()
                .getSelectedItem();
    }

    public void cargarUsuarioEnFormulario(Usuario usuario) {
        if (usuario != null) {
            txtNombre.setText(usuario.getNombre());
            txtApellido.setText(usuario.getApellido());
            txtCorreo.setText(usuario.getCorreo());
            txtEstado.setText(usuario.getEstado());
        }
    }

    // Método para limpiar las cajas de texto tras realizar una operación
    public void limpiarFormulario() {
        txtNombre.clear();
        txtApellido.clear();
        txtCorreo.clear();
        txtEstado.clear();
        tablaUsuarios.getSelectionModel().clearSelection();
    }

    public TableView<Usuario> getTablaUsuarios() {
        return tablaUsuarios;
    }
}
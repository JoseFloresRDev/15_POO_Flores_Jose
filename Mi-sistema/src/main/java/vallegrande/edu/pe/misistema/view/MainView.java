package vallegrande.edu.pe.misistema.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vallegrande.edu.pe.misistema.model.Producto;
import vallegrande.edu.pe.misistema.model.Usuario;

public class MainView extends BorderPane {

    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnProductos;
    private Button btnReportes;
    private Button btnVentas;
    private Button btnConfiguracion;

    public MainView() {
        crearMenu();
        mostrarInicio();

        // Fondo general
        setStyle("-fx-background-color: #F8FAFC;");
    }

    // =========================================================
    // MENÚ LATERAL
    // =========================================================

    private void crearMenu() {

        VBox menu = new VBox(10);

        menu.setPadding(new Insets(25, 15, 25, 15));
        menu.setPrefWidth(235);

        menu.setStyle(
                "-fx-background-color: #1E3A8A;"
        );

        // Logo / título
        Label titulo = new Label("🖥️  MI SISTEMA");

        titulo.setStyle(
                "-fx-font-size: 21px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-padding: 0 0 20 5;"
        );

        Label subtitulo = new Label("Panel administrativo");

        subtitulo.setStyle(
                "-fx-font-size: 12px;" +
                        "-fx-text-fill: #BFDBFE;" +
                        "-fx-padding: 0 0 15 5;"
        );

        // Botones
        btnInicio = crearBotonMenu("🏠", "Inicio");
        btnUsuarios = crearBotonMenu("👤", "Usuarios");
        btnProductos = crearBotonMenu("📦", "Productos");
        btnReportes = crearBotonMenu("📊", "Reportes");
        btnVentas = crearBotonMenu("🛒", "Ventas");
        btnConfiguracion = crearBotonMenu("⚙️", "Configuración");

        Label menuLabel = new Label("MENÚ PRINCIPAL");

        menuLabel.setStyle(
                "-fx-font-size: 10px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #93C5FD;" +
                        "-fx-padding: 15 5 5 5;"
        );

        menu.getChildren().addAll(
                titulo,
                subtitulo,
                menuLabel,
                btnInicio,
                btnUsuarios,
                btnProductos,
                btnReportes,
                btnVentas,
                btnConfiguracion
        );

        setLeft(menu);
    }

    // =========================================================
    // BOTONES DEL MENÚ
    // =========================================================

    private Button crearBotonMenu(String icono, String texto) {

        Button boton = new Button(icono + "   " + texto);

        boton.setPrefWidth(205);
        boton.setPrefHeight(45);

        boton.setAlignment(Pos.CENTER_LEFT);

        boton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #E0F2FE;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 0 15 0 15;"
        );

        // Efecto al pasar el mouse
        boton.setOnMouseEntered(e -> {

            boton.setStyle(
                    "-fx-background-color: #2563EB;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 10;" +
                            "-fx-padding: 0 15 0 15;"
            );
        });

        boton.setOnMouseExited(e -> {

            boton.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-text-fill: #E0F2FE;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 10;" +
                            "-fx-padding: 0 15 0 15;"
            );
        });

        return boton;
    }

    // =========================================================
    // INICIO
    // =========================================================

    public void mostrarInicio() {

        VBox contenido = new VBox(25);

        contenido.setPadding(new Insets(35));

        // Encabezado
        VBox encabezado = new VBox(5);

        Label titulo = new Label("Bienvenido 👋");

        titulo.setStyle(
                "-fx-font-size: 30px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        Label descripcion = new Label(
                "Panel principal de administración"
        );

        descripcion.setStyle(
                "-fx-font-size: 15px;" +
                        "-fx-text-fill: #64748B;"
        );

        encabezado.getChildren().addAll(
                titulo,
                descripcion
        );

        // Tarjetas
        HBox tarjetas = new HBox(20);

        tarjetas.getChildren().addAll(
                crearTarjetaDashboard(
                        "👥",
                        "Usuarios",
                        "24 registrados"
                ),

                crearTarjetaDashboard(
                        "📦",
                        "Productos",
                        "125 disponibles"
                ),

                crearTarjetaDashboard(
                        "🛒",
                        "Ventas",
                        "48 este mes"
                )
        );

        // Mensaje principal
        VBox bienvenida = new VBox(10);

        bienvenida.setPadding(new Insets(25));

        bienvenida.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 15;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 15;"
        );

        Label tituloPanel = new Label(
                "Sistema de gestión"
        );

        tituloPanel.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #1E293B;"
        );

        Label texto = new Label(
                "Utiliza el menú lateral para acceder a los diferentes módulos."
        );

        texto.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #64748B;"
        );

        bienvenida.getChildren().addAll(
                tituloPanel,
                texto
        );

        contenido.getChildren().addAll(
                encabezado,
                tarjetas,
                bienvenida
        );

        setCenter(contenido);
    }

    // =========================================================
    // USUARIOS
    // =========================================================

    public void mostrarUsuarios() {

        VBox contenido = new VBox(20);

        contenido.setPadding(new Insets(35));

        // Encabezado
        VBox encabezado = new VBox(5);

        Label titulo = new Label("Usuarios");

        titulo.setStyle(
                "-fx-font-size: 30px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        Label descripcion = new Label(
                "Administra los usuarios registrados en el sistema"
        );

        descripcion.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #64748B;"
        );

        encabezado.getChildren().addAll(
                titulo,
                descripcion
        );

        // Tarjetas superiores
        HBox resumen = new HBox(15);

        resumen.getChildren().addAll(
                crearMiniTarjeta(
                        "👥",
                        "24",
                        "Usuarios"
                ),

                crearMiniTarjeta(
                        "✓",
                        "22",
                        "Activos"
                ),

                crearMiniTarjeta(
                        "🔑",
                        "3",
                        "Roles"
                )
        );

        // Título de tabla
        Label tituloTabla = new Label(
                "Usuarios registrados"
        );

        tituloTabla.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #1E293B;"
        );

        // Tabla
        TableView<Usuario> tabla = new TableView<>();

        tabla.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;"
        );

        TableColumn<Usuario, Integer> colId =
                new TableColumn<>("ID");

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn<Usuario, String> colNombre =
                new TableColumn<>("Nombre");

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        TableColumn<Usuario, String> colRol =
                new TableColumn<>("Rol");

        colRol.setCellValueFactory(
                new PropertyValueFactory<>("rol")
        );

        TableColumn<Usuario, String> colEstado =
                new TableColumn<>("Estado");

        colEstado.setCellValueFactory(
                new PropertyValueFactory<>("estado")
        );

        colId.setPrefWidth(70);
        colNombre.setPrefWidth(250);
        colRol.setPrefWidth(200);
        colEstado.setPrefWidth(150);

        tabla.getColumns().addAll(
                colId,
                colNombre,
                colRol,
                colEstado
        );

        ObservableList<Usuario> usuarios =
                FXCollections.observableArrayList(

                        new Usuario(
                                1,
                                "Carlos Perez",
                                "Administrador",
                                "Activo"
                        ),

                        new Usuario(
                                2,
                                "Maria Lopez",
                                "Vendedora",
                                "Activo"
                        ),

                        new Usuario(
                                3,
                                "Piero Ramos",
                                "Supervisor",
                                "Activo"
                        )
                );

        tabla.setItems(usuarios);

        tabla.setPrefHeight(320);

        contenido.getChildren().addAll(
                encabezado,
                resumen,
                tituloTabla,
                tabla
        );

        setCenter(contenido);
    }

    // =========================================================
    // PRODUCTOS
    // =========================================================

    public void mostrarProductos() {

        VBox contenido = new VBox(20);

        contenido.setPadding(new Insets(35));

        // Encabezado
        VBox encabezado = new VBox(5);

        Label titulo = new Label("Productos");

        titulo.setStyle(
                "-fx-font-size: 30px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        Label descripcion = new Label(
                "Consulta y administra los productos disponibles"
        );

        descripcion.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #64748B;"
        );

        encabezado.getChildren().addAll(
                titulo,
                descripcion
        );

        // Resumen
        HBox resumen = new HBox(15);

        resumen.getChildren().addAll(
                crearMiniTarjeta(
                        "📦",
                        "125",
                        "Productos"
                ),

                crearMiniTarjeta(
                        "✓",
                        "110",
                        "Disponibles"
                ),

                crearMiniTarjeta(
                        "⚠",
                        "15",
                        "Stock bajo"
                )
        );

        Label tituloTabla = new Label(
                "Catálogo de productos"
        );

        tituloTabla.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #1E293B;"
        );

        // Tabla
        TableView<Producto> tabla = new TableView<>();

        tabla.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;"
        );

        TableColumn<Producto, Integer> colId =
                new TableColumn<>("ID");

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn<Producto, String> colNombre =
                new TableColumn<>("Producto");

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        TableColumn<Producto, Double> colPrecio =
                new TableColumn<>("Precio");

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precio")
        );

        TableColumn<Producto, Integer> colStock =
                new TableColumn<>("Stock");

        colStock.setCellValueFactory(
                new PropertyValueFactory<>("stock")
        );

        colId.setPrefWidth(70);
        colNombre.setPrefWidth(280);
        colPrecio.setPrefWidth(180);
        colStock.setPrefWidth(150);

        tabla.getColumns().addAll(
                colId,
                colNombre,
                colPrecio,
                colStock
        );

        ObservableList<Producto> productos =
                FXCollections.observableArrayList(

                        new Producto(
                                1,
                                "Laptop Lenovo",
                                2500,
                                10
                        ),

                        new Producto(
                                2,
                                "Mouse Logitech",
                                80,
                                25
                        ),

                        new Producto(
                                3,
                                "Teclado Mecánico",
                                180,
                                15
                        )
                );

        tabla.setItems(productos);

        tabla.setPrefHeight(320);

        contenido.getChildren().addAll(
                encabezado,
                resumen,
                tituloTabla,
                tabla
        );

        setCenter(contenido);
    }

    // =========================================================
    // REPORTES
    // =========================================================

    public void mostrarReportes() {

        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("Reportes");

        Label descripcion = crearDescripcion(
                "Consulta el resumen general del sistema"
        );

        HBox tarjetas = new HBox(20);

        tarjetas.getChildren().addAll(
                crearTarjetaDashboard(
                        "💰",
                        "Ventas",
                        "S/ 8,500"
                ),

                crearTarjetaDashboard(
                        "📦",
                        "Productos",
                        "125 registrados"
                ),

                crearTarjetaDashboard(
                        "👥",
                        "Usuarios",
                        "24 activos"
                )
        );

        contenido.getChildren().addAll(
                titulo,
                descripcion,
                tarjetas
        );

        setCenter(contenido);
    }

    // =========================================================
    // VENTAS
    // =========================================================

    public void mostrarVentas() {

        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("Ventas");

        Label descripcion = crearDescripcion(
                "Registro y seguimiento de las ventas realizadas"
        );

        HBox tarjetas = new HBox(20);

        tarjetas.getChildren().addAll(
                crearTarjetaDashboard(
                        "💰",
                        "Ventas del mes",
                        "S/ 8,500"
                ),

                crearTarjetaDashboard(
                        "🛒",
                        "Ventas realizadas",
                        "48"
                ),

                crearTarjetaDashboard(
                        "📈",
                        "Promedio",
                        "S/ 177"
                )
        );

        contenido.getChildren().addAll(
                titulo,
                descripcion,
                tarjetas
        );

        setCenter(contenido);
    }

    // =========================================================
    // CONFIGURACIÓN
    // =========================================================

    public void mostrarConfiguracion() {

        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("Configuración");

        Label descripcion = crearDescripcion(
                "Configuración general del sistema"
        );

        VBox panel = new VBox(15);

        panel.setPadding(new Insets(25));

        panel.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 15;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 15;"
        );

        Label usuario = new Label(
                "👤  Usuario actual: Administrador"
        );

        Label idioma = new Label(
                "🌐  Idioma: Español"
        );

        Label version = new Label(
                "ℹ️  Versión: 1.0"
        );

        usuario.setStyle(
                "-fx-font-size: 15px;" +
                        "-fx-text-fill: #334155;"
        );

        idioma.setStyle(
                "-fx-font-size: 15px;" +
                        "-fx-text-fill: #334155;"
        );

        version.setStyle(
                "-fx-font-size: 15px;" +
                        "-fx-text-fill: #334155;"
        );

        panel.getChildren().addAll(
                usuario,
                idioma,
                version
        );

        contenido.getChildren().addAll(
                titulo,
                descripcion,
                panel
        );

        setCenter(contenido);
    }

    // =========================================================
    // MÉTODOS AUXILIARES
    // =========================================================

    private VBox crearContenedor() {

        VBox contenido = new VBox(15);

        contenido.setPadding(
                new Insets(35)
        );

        return contenido;
    }

    private Label crearTitulo(String texto) {

        Label titulo = new Label(texto);

        titulo.setStyle(
                "-fx-font-size: 30px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        return titulo;
    }

    private Label crearDescripcion(String texto) {

        Label descripcion = new Label(texto);

        descripcion.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #64748B;"
        );

        return descripcion;
    }

    private VBox crearTarjetaDashboard(
            String icono,
            String titulo,
            String detalle) {

        VBox tarjeta = new VBox(8);

        tarjeta.setPadding(
                new Insets(20)
        );

        tarjeta.setPrefWidth(210);
        tarjeta.setPrefHeight(120);

        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 15;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 15;"
        );

        Label iconoLabel = new Label(icono);

        iconoLabel.setStyle(
                "-fx-font-size: 24px;"
        );

        Label nombre = new Label(titulo);

        nombre.setStyle(
                "-fx-font-size: 15px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #334155;"
        );

        Label valor = new Label(detalle);

        valor.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #2563EB;"
        );

        tarjeta.getChildren().addAll(
                iconoLabel,
                nombre,
                valor
        );

        return tarjeta;
    }

    private VBox crearMiniTarjeta(
            String icono,
            String valor,
            String texto) {

        VBox tarjeta = new VBox(5);

        tarjeta.setPadding(
                new Insets(15)
        );

        tarjeta.setPrefWidth(170);
        tarjeta.setPrefHeight(90);

        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 12;"
        );

        HBox fila = new HBox(8);

        Label iconoLabel = new Label(icono);

        iconoLabel.setStyle(
                "-fx-font-size: 18px;"
        );

        Label valorLabel = new Label(valor);

        valorLabel.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #2563EB;"
        );

        fila.getChildren().addAll(
                iconoLabel,
                valorLabel
        );

        Label textoLabel = new Label(texto);

        textoLabel.setStyle(
                "-fx-font-size: 12px;" +
                        "-fx-text-fill: #64748B;"
        );

        tarjeta.getChildren().addAll(
                fila,
                textoLabel
        );

        return tarjeta;
    }

    // =========================================================
    // GETTERS
    // =========================================================

    public Button getBtnInicio() {
        return btnInicio;
    }

    public Button getBtnUsuarios() {
        return btnUsuarios;
    }

    public Button getBtnProductos() {
        return btnProductos;
    }

    public Button getBtnReportes() {
        return btnReportes;
    }

    public Button getBtnVentas() {
        return btnVentas;
    }

    public Button getBtnConfiguracion() {
        return btnConfiguracion;
    }
}
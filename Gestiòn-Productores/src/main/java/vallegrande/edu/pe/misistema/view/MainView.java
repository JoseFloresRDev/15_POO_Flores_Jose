package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import vallegrande.edu.pe.misistema.model.Productor;

public class MainView extends BorderPane {

    private TextField txtId;
    private TextField txtNombre;
    private TextField txtDni;
    private TextField txtTelefono;
    private TextField txtComunidad;

    private Button btnRegistrar;
    private Button btnActualizar;
    private Button btnEliminar;
    private Button btnLimpiar;

    private TableView<Productor> tabla;
    private TableColumn<Productor, Integer> colId;
    private TableColumn<Productor, String> colNombre;
    private TableColumn<Productor, String> colDni;
    private TableColumn<Productor, String> colTelefono;
    private TableColumn<Productor, String> colComunidad;

    public MainView() {
        initComponents();
    }

    private void initComponents() {
        this.setPadding(new Insets(24));
        // Fondo general en todo oscuro profundo
        this.setStyle("-fx-background-color: #0f172a; -fx-font-family: 'Segoe UI', Helvetica, Arial, sans-serif;");

        // ==========================================
        // HEADER / ENCABEZADO
        // ==========================================
        Label lblIcono = new Label("🌱");
        lblIcono.setStyle("-fx-font-size: 24px;");

        Label lblTitulo = new Label("GESTIÓN DE PRODUCTORES AGRÍCOLAS");
        lblTitulo.setStyle("-fx-font-size: 20px; -fx-font-weight: 800; -fx-text-fill: #f8fafc; -fx-letter-spacing: 0.5px;");

        Label lblSubtitulo = new Label("Panel de control y registro de comunidades");
        lblSubtitulo.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");

        VBox headerText = new VBox(2, lblTitulo, lblSubtitulo);
        HBox headerBox = new HBox(12, lblIcono, headerText);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setPadding(new Insets(0, 0, 20, 0));
        this.setTop(headerBox);

        // ==========================================
        // FORMULARIO (IZQUIERDA)
        // ==========================================
        VBox formBox = new VBox(12);
        formBox.setPadding(new Insets(20));
        formBox.setStyle(
                "-fx-background-color: #1e293b; " +
                        "-fx-background-radius: 12; " +
                        "-fx-border-color: #334155; " +
                        "-fx-border-radius: 12; " +
                        "-fx-border-width: 1px;"
        );
        formBox.setPrefWidth(310);

        Label lblFormTitle = new Label("Datos del Productor");
        lblFormTitle.setStyle("-fx-font-size: 15px; -fx-font-weight: 700; -fx-text-fill: #38bdf8;");

        // Estilo base de los inputs
        String inputStyle =
                "-fx-background-color: #0f172a; " +
                        "-fx-text-fill: #f8fafc; " +
                        "-fx-prompt-text-fill: #64748b; " +
                        "-fx-border-color: #334155; " +
                        "-fx-border-radius: 8; " +
                        "-fx-background-radius: 8; " +
                        "-fx-padding: 8 12; " +
                        "-fx-font-size: 13px;";

        txtId = new TextField();
        txtId.setPromptText("Auto-generado");
        txtId.setEditable(false);
        txtId.setStyle(inputStyle + " -fx-background-color: #182234; -fx-text-fill: #64748b;");

        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre completo");
        txtNombre.setStyle(inputStyle);

        txtDni = new TextField();
        txtDni.setPromptText("DNI de 8 dígitos");
        txtDni.setStyle(inputStyle);

        txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono / Celular");
        txtTelefono.setStyle(inputStyle);

        txtComunidad = new TextField();
        txtComunidad.setPromptText("Nombre de comunidad");
        txtComunidad.setStyle(inputStyle);

        // Botones estilizados
        btnRegistrar = new Button("Registrar");
        btnRegistrar.setStyle(
                "-fx-background-color: #10b981; " +
                        "-fx-text-fill: #ffffff; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 8; " +
                        "-fx-padding: 9 15; " +
                        "-fx-cursor: hand;"
        );
        btnRegistrar.setMaxWidth(Double.MAX_VALUE);

        btnActualizar = new Button("Actualizar");
        btnActualizar.setStyle(
                "-fx-background-color: #2563eb; " +
                        "-fx-text-fill: #ffffff; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 8; " +
                        "-fx-padding: 9 15; " +
                        "-fx-cursor: hand;"
        );
        btnActualizar.setMaxWidth(Double.MAX_VALUE);

        btnEliminar = new Button("Eliminar");
        btnEliminar.setStyle(
                "-fx-background-color: #ef4444; " +
                        "-fx-text-fill: #ffffff; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 8; " +
                        "-fx-padding: 9 15; " +
                        "-fx-cursor: hand;"
        );
        btnEliminar.setMaxWidth(Double.MAX_VALUE);

        btnLimpiar = new Button("Limpiar Campos");
        btnLimpiar.setStyle(
                "-fx-background-color: transparent; " +
                        "-fx-text-fill: #94a3b8; " +
                        "-fx-border-color: #334155; " +
                        "-fx-border-radius: 8; " +
                        "-fx-background-radius: 8; " +
                        "-fx-padding: 7 15; " +
                        "-fx-cursor: hand;"
        );
        btnLimpiar.setMaxWidth(Double.MAX_VALUE);
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        VBox buttonBox = new VBox(8, btnRegistrar, btnActualizar, btnEliminar, btnLimpiar);

        Separator sep = new Separator();
        sep.setStyle("-fx-background-color: #334155;");

        formBox.getChildren().addAll(
                lblFormTitle,
                crearCampo("ID", txtId),
                crearCampo("Nombre Completo", txtNombre),
                crearCampo("DNI", txtDni),
                crearCampo("Teléfono", txtTelefono),
                crearCampo("Comunidad", txtComunidad),
                sep,
                buttonBox
        );

        this.setLeft(formBox);

        // ==========================================
        // TABLA (CENTRO)
        // ==========================================
        tabla = new TableView<>();
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabla.setStyle(
                "-fx-background-color: #1e293b; " +
                        "-fx-background-radius: 12; " +
                        "-fx-border-color: #334155; " +
                        "-fx-border-radius: 12; " +
                        "-fx-border-width: 1px;"
        );

        colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setMinWidth(60);
        colId.setMaxWidth(80);

        colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        colDni = new TableColumn<>("DNI");
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));

        colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        colComunidad = new TableColumn<>("Comunidad");
        colComunidad.setCellValueFactory(new PropertyValueFactory<>("comunidad"));

        tabla.getColumns().addAll(colId, colNombre, colDni, colTelefono, colComunidad);

        VBox centerBox = new VBox(tabla);
        centerBox.setPadding(new Insets(0, 0, 0, 20));
        HBox.setHgrow(tabla, Priority.ALWAYS);
        VBox.setVgrow(tabla, Priority.ALWAYS);

        this.setCenter(centerBox);
    }

    private VBox crearCampo(String etiqueta, TextField input) {
        Label lbl = new Label(etiqueta);
        lbl.setStyle("-fx-font-size: 11px; -fx-font-weight: 700; -fx-text-fill: #94a3b8;");
        return new VBox(4, lbl, input);
    }

    public void limpiarFormulario() {
        txtId.clear();
        txtNombre.clear();
        txtDni.clear();
        txtTelefono.clear();
        txtComunidad.clear();
        tabla.getSelectionModel().clearSelection();
    }

    public void cargarProductorEnFormulario(Productor p) {
        if (p != null) {
            txtId.setText(String.valueOf(p.getId()));
            txtNombre.setText(p.getNombre());
            txtDni.setText(p.getDni());
            txtTelefono.setText(p.getTelefono() != null ? p.getTelefono() : "");
            txtComunidad.setText(p.getComunidad() != null ? p.getComunidad() : "");
        }
    }

    // Getters
    public TextField getTxtId() { return txtId; }
    public TextField getTxtNombre() { return txtNombre; }
    public TextField getTxtDni() { return txtDni; }
    public TextField getTxtTelefono() { return txtTelefono; }
    public TextField getTxtComunidad() { return txtComunidad; }
    public Button getBtnRegistrar() { return btnRegistrar; }
    public Button getBtnActualizar() { return btnActualizar; }
    public Button getBtnEliminar() { return btnEliminar; }
    public Button getBtnLimpiar() { return btnLimpiar; }
    public TableView<Productor> getTabla() { return tabla; }
}
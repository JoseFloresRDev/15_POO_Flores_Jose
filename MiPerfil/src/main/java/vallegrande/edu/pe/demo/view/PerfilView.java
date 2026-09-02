package vallegrande.edu.pe.demo.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PerfilView {

    private VBox contenedor;
    private Label titulo;
    private TextField txtNombre;
    private TextField txtCarrera;
    private TextField txtSemestre;
    private ComboBox<String> cmbHobby;
    private Button btnMostrar;
    private Button btnLimpiar;
    private Label lblResultado;

    public PerfilView() {

        titulo = new Label("MI PERFIL");
        titulo.setId("titulo");

        txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese su nombre completo");

        txtCarrera = new TextField();
        txtCarrera.setPromptText("Ingrese su carrera profesional");

        txtSemestre = new TextField();
        txtSemestre.setPromptText("Ingrese su semestre académico");

        cmbHobby = new ComboBox<>();
        cmbHobby.getItems().addAll(
                "Videojuegos",
                "Música",
                "Deportes",
                "Lectura",
                "Dibujo"
        );
        cmbHobby.setPromptText("Seleccione su hobby");

        btnMostrar = new Button("Mostrar Perfil");
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setId("btnLimpiar");

        lblResultado = new Label();
        lblResultado.setId("resultado");

        contenedor = new VBox(10);
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);

        contenedor.getChildren().addAll(
                titulo,
                txtNombre,
                txtCarrera,
                txtSemestre,
                cmbHobby,
                btnMostrar,
                btnLimpiar,
                lblResultado
        );
    }

    public VBox getContenedor() {
        return contenedor;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public TextField getTxtCarrera() {
        return txtCarrera;
    }

    public TextField getTxtSemestre() {
        return txtSemestre;
    }

    public ComboBox<String> getCmbHobby() {
        return cmbHobby;
    }

    public Button getBtnMostrar() {
        return btnMostrar;
    }

    public Button getBtnLimpiar() {
        return btnLimpiar;
    }

    public Label getLblResultado() {
        return lblResultado;
    }
}
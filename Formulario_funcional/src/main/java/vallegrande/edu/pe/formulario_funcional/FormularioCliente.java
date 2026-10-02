package vallegrande.edu.pe.formulario_funcional;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FormularioCliente extends JFrame {

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JCheckBox chkInformacion;
    private JButton btnRegistrar;

    public FormularioCliente() {

        // =========================
        // CONFIGURACIÓN DE LA VENTANA
        // =========================

        setTitle("Registro de Cliente");
        setSize(500, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // =========================
        // PANEL PRINCIPAL
        // =========================

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(245, 247, 250));
        panelPrincipal.setBorder(new EmptyBorder(25, 35, 25, 35));

        // =========================
        // ENCABEZADO
        // =========================

        JPanel panelEncabezado = new JPanel();
        panelEncabezado.setLayout(new BoxLayout(panelEncabezado, BoxLayout.Y_AXIS));
        panelEncabezado.setBackground(new Color(245, 247, 250));

        JLabel lblTitulo = new JLabel("REGISTRO DE CLIENTE");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(35, 45, 65));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel("Complete sus datos para registrarse");
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(100, 110, 125));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelEncabezado.add(lblTitulo);
        panelEncabezado.add(Box.createVerticalStrut(8));
        panelEncabezado.add(lblSubtitulo);

        panelPrincipal.add(panelEncabezado, BorderLayout.NORTH);

        // =========================
        // PANEL DEL FORMULARIO
        // =========================

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(new Color(245, 247, 250));
        panelFormulario.setBorder(new EmptyBorder(25, 5, 10, 5));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 5, 7, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // =========================
        // NOMBRE
        // =========================

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
        lblNombre.setForeground(new Color(50, 60, 75));

        txtNombre = crearCampoTexto();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        panelFormulario.add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        panelFormulario.add(txtNombre, gbc);

        // =========================
        // APELLIDO
        // =========================

        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("Arial", Font.BOLD, 14));
        lblApellido.setForeground(new Color(50, 60, 75));

        txtApellido = crearCampoTexto();

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(lblApellido, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelFormulario.add(txtApellido, gbc);

        // =========================
        // CORREO
        // =========================

        JLabel lblCorreo = new JLabel("Correo electrónico");
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 14));
        lblCorreo.setForeground(new Color(50, 60, 75));

        txtCorreo = crearCampoTexto();

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(lblCorreo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelFormulario.add(txtCorreo, gbc);

        // =========================
        // TELÉFONO
        // =========================

        JLabel lblTelefono = new JLabel("Teléfono");
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 14));
        lblTelefono.setForeground(new Color(50, 60, 75));

        txtTelefono = crearCampoTexto();

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulario.add(lblTelefono, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelFormulario.add(txtTelefono, gbc);

        // =========================
        // CHECKBOX
        // =========================

        chkInformacion = new JCheckBox("Deseo recibir información");
        chkInformacion.setFont(new Font("Arial", Font.PLAIN, 13));
        chkInformacion.setBackground(new Color(245, 247, 250));
        chkInformacion.setForeground(new Color(70, 80, 95));
        chkInformacion.setFocusPainted(false);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        panelFormulario.add(chkInformacion, gbc);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);

        // =========================
        // BOTÓN
        // =========================

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(245, 247, 250));

        btnRegistrar = new JButton("REGISTRAR CLIENTE");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBackground(new Color(45, 100, 180));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorder(new EmptyBorder(12, 30, 12, 30));
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelBoton.add(btnRegistrar);

        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        // =========================
        // EVENTO DEL BOTÓN
        // =========================

        btnRegistrar.addActionListener(e -> registrarCliente());

        // Agregar panel principal
        add(panelPrincipal);
    }

    // =========================
    // CREAR CAMPOS DE TEXTO
    // =========================

    private JTextField crearCampoTexto() {

        JTextField campo = new JTextField();

        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        campo.setPreferredSize(new Dimension(250, 38));
        campo.setBorder(
                new LineBorder(
                        new Color(200, 205, 215),
                        1,
                        true
                )
        );

        return campo;
    }

    // =========================
    // REGISTRAR CLIENTE
    // =========================

    private void registrarCliente() {

        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();

        // =========================
        // VALIDAR CAMPOS
        // =========================

        if (nombre.isEmpty() ||
                apellido.isEmpty() ||
                correo.isEmpty() ||
                telefono.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, complete todos los campos.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // =========================
        // CHECKBOX
        // =========================

        String informacion;

        if (chkInformacion.isSelected()) {
            informacion = "Sí";
        } else {
            informacion = "No";
        }

        // =========================
        // MENSAJE DE ÉXITO
        // =========================

        JOptionPane.showMessageDialog(
                this,
                "Cliente registrado correctamente.\n\n" +
                        "Nombre: " + nombre + "\n" +
                        "Apellido: " + apellido + "\n" +
                        "Correo: " + correo + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Recibir información: " + informacion,
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =========================
    // MÉTODO PRINCIPAL
    // =========================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            FormularioCliente formulario = new FormularioCliente();

            formulario.setVisible(true);
        });
    }
}
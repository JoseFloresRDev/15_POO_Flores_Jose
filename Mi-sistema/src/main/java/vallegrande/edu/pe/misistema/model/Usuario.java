package vallegrande.edu.pe.misistema.model;

public class Usuario {

    private int id;
    private String nombre;
    private String rol;
    private String estado;

    public Usuario(int id, String nombre, String rol, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public String getEstado() {
        return estado;
    }
}
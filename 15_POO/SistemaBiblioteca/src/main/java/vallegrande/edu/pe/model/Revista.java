package vallegrande.edu.pe.model;

public class Revista {

    // ATRIBUTOS
    private int id;
    private String titulo;
    private String editor;
    private int anio;

    // CONSTRUCTOR
    public Revista(int id, String titulo, String editor, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.editor = editor;
        this.anio = anio;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditor() {
        return editor;
    }

    public int getAnio() {
        return anio;
    }

    // MOSTRAR REVISTA
    public void mostrarRevista() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Editor: " + editor);
        System.out.println("Año: " + anio);
        System.out.println("------------------------------------");
    }
}
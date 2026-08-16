package vallegrande.edu.pe.view;

public class BibliotecaView {

    public void mostrarTitulo() {
        System.out.println("==============================");
        System.out.println("     SISTEMA DE BIBLIOTECA VG");
        System.out.println("==============================");
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("========= MENÚ PRINCIPAL =========");
        System.out.println("1. Registrar Libro");
        System.out.println("2. Listar Libros");
        System.out.println("3. Buscar Libro");
        System.out.println("4. Registrar Revista");
        System.out.println("5. Listar Revistas");
        System.out.println("6. Salir");
        System.out.println("==================================");
        System.out.println("Seleccione una opción:");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
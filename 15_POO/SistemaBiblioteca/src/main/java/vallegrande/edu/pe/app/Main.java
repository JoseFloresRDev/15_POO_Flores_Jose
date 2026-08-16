package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.BibliotecaController;
import vallegrande.edu.pe.controller.RevistaController;
import vallegrande.edu.pe.model.Libro;
import vallegrande.edu.pe.model.Revista;
import vallegrande.edu.pe.view.BibliotecaView;

import java.util.Scanner;

public class
Main {

    public static void main(String[] args) {

        BibliotecaController controller = new BibliotecaController();
        RevistaController revistaController = new RevistaController();
        BibliotecaView view = new BibliotecaView();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            view.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                // REGISTRAR LIBRO
                case 1:
                    System.out.println("ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Título:");
                    String titulo = scanner.nextLine();

                    System.out.println("Autor:");
                    String autor = scanner.nextLine();

                    System.out.println("Año:");
                    int anio = scanner.nextInt();
                    scanner.nextLine();

                    // VALIDAR DATOS
                    if (titulo.trim().isEmpty()) {
                        System.out.println("El título no puede estar vacío");

                    } else if (autor.trim().isEmpty()) {
                        System.out.println("El nombre del autor no puede estar vacío");

                    } else if (anio <= 0) {
                        System.out.println("El año debe ser mayor a 0");

                    } else {
                        Libro libro = new Libro(id, titulo, autor, anio);
                        controller.agregarLibro(libro);
                    }
                    break;

                // LISTAR LIBROS
                case 2:
                    controller.listarLibros();
                    break;

                // BUSCAR LIBRO
                case 3:
                    System.out.println("Ingrese Título o Autor:");
                    String criterio = scanner.nextLine();

                    if (criterio.trim().isEmpty()) {
                        System.out.println("El criterio de búsqueda no puede estar vacío");
                    } else {
                        controller.buscarLibro(criterio);
                    }
                    break;

                // REGISTRAR REVISTA
                case 4:
                    System.out.println("ID:");
                    int idRevista = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Título:");
                    String tituloRevista = scanner.nextLine();

                    System.out.println("Editor:");
                    String editor = scanner.nextLine();

                    System.out.println("Año:");
                    int anioRevista = scanner.nextInt();
                    scanner.nextLine();

                    // VALIDAR DATOS DE LA REVISTA
                    if (tituloRevista.trim().isEmpty() || editor.trim().isEmpty()
                            || anioRevista <= 0) {

                        System.out.println("Datos no válidos");

                    } else {
                        Revista revista = new Revista(
                                idRevista,
                                tituloRevista,
                                editor,
                                anioRevista
                        );

                        revistaController.agregarRevista(revista);
                    }
                    break;

                // LISTAR REVISTAS
                case 5:
                    revistaController.listarRevistas();
                    break;

                // SALIR
                case 6:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 6);

        scanner.close();
    }
}
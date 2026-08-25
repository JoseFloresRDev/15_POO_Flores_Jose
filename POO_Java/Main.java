import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Agenda agenda = new Agenda();

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("      AGENDA DE CONTACTOS");
            System.out.println("==============================");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\n===== REGISTRAR CONTACTO =====");

                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Ingrese el correo: ");
                    String correo = scanner.nextLine();

                    Contacto contacto = new Contacto(
                            nombre,
                            telefono,
                            correo
                    );

                    agenda.registrarContacto(contacto);

                    break;

                case 2:

                    agenda.mostrarContactos();

                    break;

                case 3:

                    System.out.println("\n===== BUSCAR CONTACTO =====");

                    System.out.print("Ingrese el nombre que desea buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    agenda.buscarContacto(nombreBuscar);

                    break;

                case 4:

                    System.out.println("\nSaliendo del programa...");
                    System.out.println("Gracias por utilizar la agenda.");

                    break;

                default:

                    System.out.println("\nOpción no válida.");

                    break;
            }

        } while (opcion != 4);

        scanner.close();
    }
}

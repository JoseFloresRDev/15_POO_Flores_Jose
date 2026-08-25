import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void registrarContacto(Contacto contacto) {
        contactos.add(contacto);
        System.out.println("Contacto registrado correctamente.");
    }

    public void mostrarContactos() {

        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE CONTACTOS =====");

        for (Contacto contacto : contactos) {
            contacto.mostrarDatos();
            System.out.println("-----------------------------");
        }
    }

    public void buscarContacto(String nombre) {

        for (Contacto contacto : contactos) {

            if (contacto.getNombre().equalsIgnoreCase(nombre)) {

                System.out.println("\n===== CONTACTO ENCONTRADO =====");
                contacto.mostrarDatos();

                return;
            }
        }

        System.out.println("No se encontró el contacto.");
    }
}

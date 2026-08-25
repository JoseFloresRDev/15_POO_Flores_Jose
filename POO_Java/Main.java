public class Main {

    public static void main(String[] args) {

        Producto producto1 = new Producto(
                "Laptop Lenovo",
                "P001",
                2500.00,
                10,
                "Tecnología"
        );

        System.out.println("Nombre obtenido con GET: " + producto1.getNombre());

        producto1.setPrecio(2300.00);

        producto1.mostrarDatos();
    }
}

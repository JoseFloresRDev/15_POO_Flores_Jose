package vallegrande.edu.pe.misistema.model;

public class Venta {

    private int id;
    private String producto;
    private double monto;

    public Venta(int id, String producto, double monto) {
        this.id = id;
        this.producto = producto;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public double getMonto() {
        return monto;
    }
}
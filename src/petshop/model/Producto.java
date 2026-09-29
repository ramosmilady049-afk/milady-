package petshop.model;

/** Clase Producto */
public class Producto {
    private String idProducto;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    public void actualizarStock() {}
    public boolean verificarDisponibilidad() { return stock > 0; }
}
package petshop.model;

/** Clase DetalleVenta */
public class DetalleVenta {
    private String idDetalle;
    private String idVenta;
    private String idProducto;
    private int cantidad;
    private double subtotal;

    public double calcularSubtotal() { return subtotal; }
}
package petshop.model;

/** Clase Venta */
public class Venta {
    private String idVenta;
    private String fecha;
    private String idCliente;
    private String idEmpleado;
    private double total;

    public void registrarVenta() {}
    public double calcularTotal() { return total; }
    public void emitirComprobante() {}
}
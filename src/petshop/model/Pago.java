package petshop.model;

/** Clase Pago */
public class Pago {
    private String idPago;
    private String idVenta;
    private double monto;
    private String metodoPago;
    private String fecha;

    public void registrarPago() {}
    public boolean validarMonto(double total) { return monto >= total; }
}
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarjeta {
    private long numeroTarjeta;
    private Date fechaVencimiento;
    private short numeroCVC;

    // Constructor
    public Tarjeta(long numeroTarjeta, Date fechaVencimiento, short numeroCVC) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.numeroCVC = numeroCVC;
    }

    // Getters
    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public short getNumeroCVC() {
        return numeroCVC;
    }

    // Setters
    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setNumeroCVC(short numeroCVC) {
        this.numeroCVC = numeroCVC;
    }

    // Método toString para imprimir los detalles de la tarjeta
    @Override
    public String toString() {
        return "Tarjeta{" +
                "numeroTarjeta=" + numeroTarjeta +
                ", fechaVencimiento=" + fechaVencimiento +
                ", numeroCVC=" + numeroCVC +
                '}';
    }

    // Método main para probar la clase Tarjeta
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaVencimiento = null;

        try {
            fechaVencimiento = sdf.parse("2025-12-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Crear una instancia de Tarjeta
        Tarjeta tarjeta = new Tarjeta(1234567890123456L, fechaVencimiento, (short) 123);

        // Imprimir los detalles de la tarjeta
        System.out.println(tarjeta);

        // Probar los setters
        tarjeta.setNumeroTarjeta(6543210987654321L);
        try {
            tarjeta.setFechaVencimiento(sdf.parse("2026-06-30"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tarjeta.setNumeroCVC((short) 321);

        // Imprimir los detalles actualizados de la tarjeta
        System.out.println(tarjeta);
    }
}

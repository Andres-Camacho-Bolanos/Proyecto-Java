import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Cita {
    private int numeroCita;
    private Date fechaHora;
    private Cliente cliente;
    private Mascota mascota;
    private Veterinario veterinario;
    private Asistente asistente;
    private String descripcionServicio;
    private String[] paquetes;

    // Constructor
    public Cita(int numeroCita, Date fechaHora, Cliente cliente, Mascota mascota, Veterinario veterinario, Asistente asistente, String descripcionServicio, String[] paquetes) {
        this.numeroCita = numeroCita;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.asistente = asistente;
        this.descripcionServicio = descripcionServicio;
        this.paquetes = paquetes;
    }

    // Getters y Setters
    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String[] getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(String[] paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "numeroCita=" + numeroCita +
                ", fechaHora=" + fechaHora +
                ", cliente=" + cliente +
                ", mascota=" + mascota +
                ", veterinario=" + veterinario +
                ", asistente=" + asistente +
                ", descripcionServicio='" + descripcionServicio + '\'' +
                ", paquetes=" + Arrays.toString(paquetes) +
                '}';
    }

     // Método principal para probar la clase Cita
    public static void main(String[] args) {
        // Crear instancias de Cliente, Mascota, Veterinario y Asistente
        Date fechaNacimientoCliente = new Date(); // Fecha actual para ejemplo
        Mascota mascota = new Mascota("Firulais", "Labrador", 1, new String[]{"Rabia", "Parvovirus"});
        Cliente cliente = new Cliente("Ana", "López", "Martínez", fechaNacimientoCliente, "ANLM900101HDFLPN01", 12345, Arrays.asList(mascota));

        Date fechaNacimientoVeterinario = new Date(); // Fecha actual para ejemplo
        Veterinario veterinario = new Veterinario("Carlos", "González", "Fernández", fechaNacimientoVeterinario, "CAGF850101HDFGRL09", 123456);

        Date fechaNacimientoAsistente = new Date(); // Fecha actual para ejemplo
        Asistente asistente = new Asistente("Pedro", "López", "Martínez", fechaNacimientoAsistente, "PLLM900101HDFLRN09", 98765);

        // Crear instancia de Cita
        Date fechaHoraCita = new Date(); // Fecha y hora actuales para ejemplo
        String[] paquetes = {"Consulta general", "Vacunación"};
        Cita cita = new Cita(1, fechaHoraCita, cliente, mascota, veterinario, asistente, "Consulta general y vacunación", paquetes);

        // Mostrar los detalles de la cita
        System.out.println(cita);
    }
}

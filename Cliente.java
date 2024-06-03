import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String paterno;
    private String materno;
    private Date fechaNacimiento;
    private String curp;
    private int numeroCliente;
    private List<Mascota> mascotas;

    // Constructor
    public Cliente(String nombre, String paterno, String materno, Date fechaNacimiento, String curp, int numeroCliente, List<Mascota> mascotas) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.numeroCliente = numeroCliente;
        this.mascotas = mascotas;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    // Método principal para probar la clase Cliente
    public static void main(String[] args) {
        // Crear instancias de Mascota
        Mascota mascota1 = new Mascota("Firulais", "Labrador", 1, new String[]{"Rabia", "Parvovirus"});
        Mascota mascota2 = new Mascota("Michi", "Persa", 2, new String[]{"Leucemia Felina"});
        
        // Crear una lista de mascotas
        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(mascota1);
        mascotas.add(mascota2);

        // Crear instancia de Cliente
        Date fechaNacimientoCliente = new Date(); // Fecha actual para ejemplo
        Cliente cliente = new Cliente("Ana", "López", "Martínez", fechaNacimientoCliente, "ANLM900101HDFLPN01", 12345, mascotas);

        // Mostrar los detalles del cliente
        System.out.println(cliente);
    }
}

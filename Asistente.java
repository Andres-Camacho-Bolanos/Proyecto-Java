import java.util.Date;

public class Asistente extends Persona {
    private int numeroAsistente;

    public Asistente(String nombre, String paterno, String materno, Date fechaNacimiento, String CURP, int numeroAsistente) {
        super(nombre, paterno, materno, fechaNacimiento, CURP);
        this.numeroAsistente = numeroAsistente;
    }

    public int getNumeroAsistente() {
        return numeroAsistente;
    }

    public void setNumeroAsistente(int numeroAsistente) {
        this.numeroAsistente = numeroAsistente;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Date fechaNacimientoAsistente = new Date(); // Fecha actual para ejemplo
        Asistente asistente = new Asistente("Pedro", "López", "Martínez", fechaNacimientoAsistente, "PLLM900101HDFLRN09", 12345);
        
        // Imprimir detalles del asistente
        System.out.println("Detalles del asistente: Estudiante liberando su servicio social");
        System.out.println("Nombre: " + asistente.getNombre());
        System.out.println("Apellido Paterno: " + asistente.getPaterno());
        System.out.println("Apellido Materno: " + asistente.getMaterno());
        System.out.println("Fecha de Nacimiento: " + asistente.getFecha_nacimiento());
        System.out.println("CURP: " + asistente.getCURP());
        System.out.println("Número de Asistente: " + asistente.getNumeroAsistente());
    }
}

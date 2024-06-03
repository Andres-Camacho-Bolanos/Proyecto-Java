import java.util.Date;

public class Veterinario extends Persona {
    private int numeroCedula;

    // Constructor
    public Veterinario(String nombre, String paterno, String materno, Date fechaNacimiento, String CURP, int numeroCedula) {
        super(nombre, paterno, materno, fechaNacimiento, CURP);
        this.numeroCedula = numeroCedula;
    }

    // Getter
    public int getNumeroCedula() {
        return numeroCedula;
    }

    // Setter
    public void setNumeroCedula(int numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    // Método toString para imprimir los detalles del veterinario
    //Override
    public String toString() {
        return "Veterinario{" +
                "numeroCedula=" + numeroCedula +
                ", nombre='" + getNombre() + '\'' +
                ", paterno='" + getPaterno() + '\'' +
                ", materno='" + getMaterno() + '\'' +
                ", fecha_nacimiento=" + getFecha_nacimiento() +
                ", CURP='" + getCURP() + '\'' +
                '}';
    }

    // Método principal para probar la clase Veterinario
    public static void main(String[] args) {
        // Crear una instancia de Veterinario
        Date fechaNacimientoVeterinario = new Date(); // Fecha actual para ejemplo
        Veterinario veterinario = new Veterinario("Carlos", "González", "Fernández", fechaNacimientoVeterinario, "CAGF850101HDFGRL09", 123456);

        // Imprimir detalles del veterinario
        System.out.println(veterinario);
    }
}

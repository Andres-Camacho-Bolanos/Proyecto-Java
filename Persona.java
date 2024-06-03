import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
    private String nombre;
    private String paterno;
    private String materno;
    private Date fecha_nacimiento;
    private String CURP;

    // Constructor
    public Persona(String nombre, String paterno, String materno, Date fecha_nacimiento, String CURP) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.CURP = CURP;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    // Sobrescritura del método toString()
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", CURP='" + CURP + '\'' +
                '}';
    }

    // Método main para probar la clase Persona
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        
        try {
            fechaNacimiento = sdf.parse("1990-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Crear una instancia de Persona
        Persona persona = new Persona("Juan", "Pérez", "López", fechaNacimiento, "JUAP900101HDFLNS01");

        // Imprimir los detalles de la persona
        System.out.println(persona);

        // Probar los setters
        persona.setNombre("Carlos");
        persona.setPaterno("García");
        persona.setMaterno("Martínez");
        try {
            persona.setFecha_nacimiento(sdf.parse("1985-05-15"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        persona.setCURP("CAGM850515HDFLNS02");

        // Imprimir los detalles actualizados de la persona
        System.out.println(persona);
    }
}

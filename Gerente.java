import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Gerente extends Persona {
    private Sucursal sucursal;
    private int numeroGerente;
    private List<Cita> citas;

    // Constructor
    public Gerente(String nombre, String paterno, String materno, Date fechaNacimiento, String CURP, Sucursal sucursal, int numeroGerente) {
        super(nombre, paterno, materno, fechaNacimiento, CURP);
        this.sucursal = sucursal;
        this.numeroGerente = numeroGerente;
        this.citas = new ArrayList<>();
    }

    // Getters y Setters
    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public int getNumeroGerente() {
        return numeroGerente;
    }

    public void setNumeroGerente(int numeroGerente) {
        this.numeroGerente = numeroGerente;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    // Métodos para ordenar y mostrar las citas
    public void mostrarCitasOrdenadas() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("Seleccione el criterio de ordenamiento:");
            System.out.println("1. Fecha");
            System.out.println("2. Nombre del cliente");
            System.out.println("3. Apellido Paterno");
            System.out.println("4. Apellido Materno");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Collections.sort(citas, Comparator.comparing(Cita::getFechaHora));
                    break;
                case 2:
                    Collections.sort(citas, Comparator.comparing(cita -> cita.getCliente().getNombre()));
                    break;
                case 3:
                    Collections.sort(citas, Comparator.comparing(cita -> cita.getCliente().getPaterno()));
                    break;
                case 4:
                    Collections.sort(citas, Comparator.comparing(cita -> cita.getCliente().getMaterno()));
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    continue;
            }

            if (continuar) {
                System.out.println("Listado de citas ordenadas:");
                for (Cita cita : citas) {
                    System.out.println(cita);
                }

                System.out.println("¿Desea descargar el listado a un archivo? (S/N)");
                char respuesta = scanner.next().toUpperCase().charAt(0);

                if (respuesta == 'S') {
                    System.out.println("Ingrese el nombre del archivo:");
                    String nombreArchivo = scanner.next();
                    try {
                        escribirListadoAArchivo(nombreArchivo);
                        System.out.println("Listado guardado en " + nombreArchivo);
                    } catch (IOException e) {
                        System.out.println("Error al escribir el archivo: " + e.getMessage());
                    }
                }
            }
        }
    }

    // Método para escribir el listado a un archivo
    public void escribirListadoAArchivo(String nombreArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Cita cita : citas) {
                writer.write(cita.toString());
                writer.newLine();
            }
        }
    }

    // Métodos para ordenar ascendente y descendente (ejemplo para nombre)
    public void ordenarCitasPorNombre(boolean ascendente) {
        if (ascendente) {
            Collections.sort(citas, Comparator.comparing(cita -> cita.getCliente().getNombre()));
        } else {
            Collections.sort(citas, Comparator.comparing(cita -> cita.getCliente().getNombre()).reversed());
        }
    }

    // Método toString para imprimir los detalles del gerente
    @Override
    public String toString() {
        return "Gerente{" +
                "sucursal=" + sucursal +
                ", numeroGerente=" + numeroGerente +
                ", nombre='" + getNombre() + '\'' +
                ", paterno='" + getPaterno() + '\'' +
                ", materno='" + getMaterno() + '\'' +
                ", fecha_nacimiento=" + getFecha_nacimiento() +
                ", CURP='" + getCURP() + '\'' +
                '}';
    }

    // Método principal para probar la clase Gerente y las funcionalidades de citas
    public static void main(String[] args) {
        try {
            // Crear instancia de Gerente
            Date fechaNacimientoGerente = new Date(); // Fecha actual para ejemplo
            Gerente gerente = new Gerente("Laura", "Hernández", "Gómez", fechaNacimientoGerente, "LHGG850101HDFHRL09", Sucursal.ZONA_NORTE, 67890);

            // Crear instancias de Cliente, Mascota, Veterinario y Asistente
            Date fechaNacimientoCliente = new Date(); // Fecha actual para ejemplo
            Mascota mascota = new Mascota("Firulais", "Labrador", 1, new String[]{"Rabia", "Parvovirus"});
            List<Mascota> mascotas = new ArrayList<>();
            mascotas.add(mascota);
            Cliente cliente = new Cliente("Ana", "López", "Martínez", fechaNacimientoCliente, "ANLM900101HDFLPN01", 12345, mascotas);

            Date fechaNacimientoVeterinario = new Date(); // Fecha actual para ejemplo
            Veterinario veterinario = new Veterinario("Carlos", "González", "Fernández", fechaNacimientoVeterinario, "CAGF850101HDFGRL09", 123456);

            Date fechaNacimientoAsistente = new Date(); // Fecha actual para ejemplo
            Asistente asistente = new Asistente("Pedro", "López", "Martínez", fechaNacimientoAsistente, "PLLM900101HDFLRN09", 98765);

            // Crear instancias de Cita
            Date fechaHoraCita1 = new Date(); // Fecha y hora actuales para ejemplo
            String[] paquetes1 = {"Consulta general", "Vacunación"};
            Cita cita1 = new Cita(1, fechaHoraCita1, cliente, mascota, veterinario, asistente, "Consulta general y vacunación", paquetes1);

            Date fechaHoraCita2 = new Date(System.currentTimeMillis() + 3600000); // Una hora después para ejemplo
            String[] paquetes2 = {"Desparasitación"};
            Cita cita2 = new Cita(2, fechaHoraCita2, cliente, mascota, veterinario, asistente, "Desparasitación", paquetes2);

            // Agregar citas al gerente
            gerente.agregarCita(cita1);
            gerente.agregarCita(cita2);

            // Mostrar y ordenar citas
            gerente.mostrarCitasOrdenadas();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



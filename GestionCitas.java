import java.util.ArrayList;
import java.util.Date;
import java.util.List;

interface revisionDeCitas {
    boolean asistenteDisponible(String nombre, String paterno, String materno);
    boolean veterinarioDisponible(String nombre, String paterno, String materno);
    boolean mascotaVacunada(int numeroMascota);
    boolean revisarDisponibilidad(Date fechaCita);
}

public class GestionCitas implements revisionDeCitas {
    private List<Cliente> clientes;
    private List<Asistente> asistentes;
    private List<Veterinario> veterinarios;
    private List<Mascota> mascotas;
    private List<Cita> citas;

    public GestionCitas() {
        clientes = new ArrayList<>();
        asistentes = new ArrayList<>();
        veterinarios = new ArrayList<>();
        mascotas = new ArrayList<>();
        citas = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(int numeroCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNumeroCliente() == numeroCliente) {
                return cliente;
            }
        }
        return null;
    }

    public void agregarAsistente(Asistente asistente) {
        asistentes.add(asistente);
    }

    public void agregarVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
    }

    public Veterinario buscarVeterinario(String nombre) {
        for (Veterinario veterinario : veterinarios) {
            if (veterinario.getNombre().equalsIgnoreCase(nombre)) {
                return veterinario;
            }
        }
        return null;
    }

    public Asistente buscarAsistente(String nombre) {
        for (Asistente asistente : asistentes) {
            if (asistente.getNombre().equalsIgnoreCase(nombre)) {
                return asistente;
            }
        }
        return null;
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    @Override
    public boolean revisarDisponibilidad(Date fechaCita) {
        for (Cita cita : citas) {
            if (cita.getFechaHora().equals(fechaCita)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean asistenteDisponible(String nombre, String paterno, String materno) {
        for (Asistente asistente : asistentes) {
            if (asistente.getNombre().equalsIgnoreCase(nombre) &&
                asistente.getPaterno().equalsIgnoreCase(paterno) &&
                asistente.getMaterno().equalsIgnoreCase(materno)) {

                // Verificar si el asistente no tiene una cita en la fecha solicitada
                for (Cita cita : citas) {
                    if (cita.getAsistente().equals(asistente)) {
                        return false; // Asistente no disponible
                    }
                }
                return true; // Asistente disponible
            }
        }
        return false; // Asistente no encontrado
    }

    @Override
    public boolean veterinarioDisponible(String nombre, String paterno, String materno) {
        for (Veterinario veterinario : veterinarios) {
            if (veterinario.getNombre().equalsIgnoreCase(nombre) &&
                veterinario.getPaterno().equalsIgnoreCase(paterno) &&
                veterinario.getMaterno().equalsIgnoreCase(materno)) {

                // Verificar si el veterinario no tiene una cita en la fecha solicitada
                for (Cita cita : citas) {
                    if (cita.getVeterinario().equals(veterinario)) {
                        return false; // Veterinario no disponible
                    }
                }
                return true; // Veterinario disponible
            }
        }
        return false; // Veterinario no encontrado
    }

    @Override
    public boolean mascotaVacunada(int numeroMascota) {
        for (Mascota mascota : mascotas) {
            if (mascota.getNumeroMascota() == numeroMascota) {
                return mascota.tieneVacunas(); // Suponiendo que Mascota tiene un método para verificar vacunas
            }
        }
        return false; // Mascota no encontrada o no vacunada
    }

    public static void main(String[] args) {
        GestionCitas gestionCitas = new GestionCitas();

        // Ejemplo de uso de los métodos implementados
        Cliente cliente = new Cliente("Juan", "Perez", "Lopez", new Date(), "CURP123456", 1, null);
        Asistente asistente = new Asistente("Ana", "Gomez", "Hernandez", new Date(), "CURP654321", 1);
        Veterinario veterinario = new Veterinario("Carlos", "Rodriguez", "Martinez", new Date(), "CURP789123", 1);
        Mascota mascota = new Mascota("Fido", "Labrador", 1, new String[]{"Rabia", "Parvovirus"});
        Cita cita = new Cita(1, new Date(), cliente, mascota, veterinario, asistente, "Consulta general", new String[]{"Vacunación"});

        gestionCitas.agregarCliente(cliente);
        gestionCitas.agregarAsistente(asistente);
        gestionCitas.agregarVeterinario(veterinario);
        gestionCitas.agregarMascota(mascota);
        gestionCitas.agregarCita(cita);

        System.out.println("Asistente disponible: " + gestionCitas.asistenteDisponible("Ana", "Gomez", "Hernandez"));
        System.out.println("Veterinario disponible: " + gestionCitas.veterinarioDisponible("Carlos", "Rodriguez", "Martinez"));
        System.out.println("Mascota vacunada: " + gestionCitas.mascotaVacunada(1));
        System.out.println("Disponibilidad de fecha de cita: " + gestionCitas.revisarDisponibilidad(new Date()));
    }
}

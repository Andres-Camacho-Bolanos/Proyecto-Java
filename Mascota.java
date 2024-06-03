import java.util.Arrays;

public class Mascota {
    private String nombre;
    private String raza;
    private int numeroMascota;
    private String[] vacunas;

    // Constructor
    public Mascota(String nombre, String raza, int numeroMascota, String[] vacunas) {
        this.nombre = nombre;
        this.raza = raza;
        this.numeroMascota = numeroMascota;
        this.vacunas = vacunas;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNumeroMascota() {
        return numeroMascota;
    }

    public void setNumeroMascota(int numeroMascota) {
        this.numeroMascota = numeroMascota;
    }

    public String[] getVacunas() {
        return vacunas;
    }

    public void setVacunas(String[] vacunas) {
        this.vacunas = vacunas;
    }

    // Método para verificar si la mascota tiene vacunas
    public boolean tieneVacunas() {
        return vacunas != null && vacunas.length > 0;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", numeroMascota=" + numeroMascota +
                ", vacunas=" + Arrays.toString(vacunas) +
                '}';
    }

    // Método main para probar la clase Mascota
    public static void main(String[] args) {
        // Crear una instancia de Mascota
        String[] vacunas = {"Rabia", "Parvovirus"};
        Mascota mascota = new Mascota("Firulais", "Labrador", 1, vacunas);

        // Imprimir los detalles de la mascota
        System.out.println(mascota);

        // Probar los setters
        mascota.setNombre("Max");
        mascota.setRaza("Golden Retriever");
        mascota.setNumeroMascota(2);
        mascota.setVacunas(new String[]{"Rabia", "Parvovirus", "Moquillo"});

        // Imprimir los detalles actualizados de la mascota
        System.out.println(mascota);
    }
}

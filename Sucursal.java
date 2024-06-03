public enum Sucursal {
    ZONA_NORTE("Zona Norte"),
    ZONA_SUR("Zona Sur"),
    ZONA_ESTE("Zona Este"),
    ZONA_OESTE("Zona Oeste");

    private final String nombre;

    Sucursal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    // Método main para probar la enum Sucursal
    public static void main(String[] args) {
        // Probar el método getNombre
        for (Sucursal sucursal : Sucursal.values()) {
            System.out.println("Sucursal: " + sucursal + ", Nombre: " + sucursal.getNombre());
        }

        // Probar el método toString
        System.out.println("Imprimir usando toString:");
        System.out.println(Sucursal.ZONA_NORTE);
        System.out.println(Sucursal.ZONA_SUR);
        System.out.println(Sucursal.ZONA_ESTE);
        System.out.println(Sucursal.ZONA_OESTE);
    }
}

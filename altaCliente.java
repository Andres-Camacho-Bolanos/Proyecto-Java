private static void altaCliente(GestionCitas gestionCitas, Scanner scanner) {
    System.out.println("Alta de Cliente:");

    System.out.print("Ingrese el nombre: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese el apellido paterno (puede dejar vacío): ");
    String paterno = scanner.nextLine();
    if (paterno.isEmpty()) {
        paterno = null;
    }

    System.out.print("Ingrese el apellido materno (puede dejar vacío): ");
    String materno = scanner.nextLine();
    if (materno.isEmpty()) {
        materno = null;
    }

    System.out.print("Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
    String fechaNacimientoStr = scanner.nextLine();
    Date fechaNacimiento = null;
    try {
        fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimientoStr);
    } catch (Exception e) {
        System.out.println("Formato de fecha incorrecto.");
        return;
    }

    System.out.print("Ingrese el CURP: ");
    String CURP = scanner.nextLine();

    System.out.print("Ingrese el número de cliente: ");
    int numeroCliente = scanner.nextInt();
    scanner.nextLine();  // Consumir la nueva línea

    // Crear una mascota para el cliente
    Mascota mascota = new Mascota("Sin nombre", "Sin raza", 0, new String[]{});

    Cliente cliente = new Cliente(nombre, paterno, materno, fechaNacimiento, CURP, numeroCliente, mascota);
    gestionCitas.agregarCliente(cliente);

    System.out.println("Cliente registrado exitosamente.");
}

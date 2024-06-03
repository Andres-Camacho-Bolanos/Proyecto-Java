import java.util.*;

public class Main {
    public static void main(String[] args) {
        GestionCitas gestionCitas = new GestionCitas();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menú Principal:");
            System.out.println("1. Alta de cliente");
            System.out.println("2. Alta de mascota");
            System.out.println("3. Alta y Baja de veterinarios o asistente personal");
            System.out.println("4. Alta de gerente en sucursal");
            System.out.println("5. Registro de citas de veterinarios a domicilio");
            System.out.println("6. Alta de paquetes");
            System.out.println("7. Adopción o devolución de mascotas");
            System.out.println("8. Pago de paquetes");
            System.out.println("9. Consulta de citas de veterinarios");
            System.out.println("10. Consulta de paquetes");
            System.out.println("11. Consulta de adopciones");
            System.out.println("12. Consulta de veterinarios");
            System.out.println("13. Escritura a archivo de citas");
            System.out.println("14. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (option) {
                case 1:
                    altaCliente(gestionCitas, scanner);
                    break;
                case 2:
                    altaMascota(gestionCitas, scanner);
                    break;
                case 3:
                    altaBajaVeterinariosAsistentes(gestionCitas, scanner);
                    break;
                case 4:
                    altaGerente(gestionCitas, scanner);
                    break;
                case 5:
                    registroCitas(gestionCitas, scanner);
                    break;
                case 6:
                    altaPaquetes(gestionCitas, scanner);
                    break;
                case 7:
                    adopcionDevolucionMascotas(gestionCitas, scanner);
                    break;
                case 8:
                    pagoPaquetes(gestionCitas, scanner);
                    break;
                case 9:
                    consultaCitas(gestionCitas, scanner);
                    break;
                case 10:
                    consultaPaquetes(gestionCitas, scanner);
                    break;
                case 11:
                    consultaAdopciones(gestionCitas, scanner);
                    break;
                case 12:
                    consultaVeterinarios(gestionCitas, scanner);
                    break;
                case 13:
                    escrituraArchivoCitas(gestionCitas, scanner);
                    break;
                case 14:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }

        scanner.close();
    }

    
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


    private static void altaMascota(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("Ingrese el nombre de la mascota:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese la raza de la mascota:");
        String raza = scanner.nextLine();
        
        System.out.println("Ingrese el número de la mascota:");
        int numeroMascota = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        System.out.println("Ingrese el número de vacunas aplicadas:");
        int numVacunas = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        String[] vacunas = new String[numVacunas];
        for (int i = 0; i < numVacunas; i++) {
            System.out.println("Ingrese el nombre de la vacuna " + (i + 1) + ":");
            vacunas[i] = scanner.nextLine();
        }
        
        Mascota mascota = new Mascota(nombre, raza, numeroMascota, vacunas);
        gestionCitas.agregarMascota(mascota);
        
        System.out.println("Mascota agregada exitosamente.");
    }

    private static void altaBajaVeterinariosAsistentes(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("¿Desea dar de alta o de baja? (alta/baja):");
        String opcion = scanner.nextLine();
        
        if (opcion.equalsIgnoreCase("alta")) {
            System.out.println("¿Es veterinario o asistente? (veterinario/asistente):");
            String tipo = scanner.nextLine();
            
            System.out.println("Ingrese el nombre:");
            String nombre = scanner.nextLine();
            
            System.out.println("Ingrese el apellido paterno:");
            String paterno = scanner.nextLine();
            
            System.out.println("Ingrese el apellido materno (o presione Enter si no tiene):");
            String materno = scanner.nextLine();
            if (materno.trim().isEmpty()) {
                materno = null;
            }
            
            if (tipo.equalsIgnoreCase("veterinario")) {
                System.out.println("Ingrese el número de cédula:");
                int numeroCedula = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                Veterinario veterinario = new Veterinario(nombre, paterno, materno, null, null, numeroCedula);
                gestionCitas.agregarVeterinario(veterinario);
                
                System.out.println("Veterinario agregado exitosamente.");
            } else if (tipo.equalsIgnoreCase("asistente")) {
                Asistente asistente = new Asistente(nombre, paterno, materno, null, null);
                gestionCitas.agregarAsistente(asistente);
                
                System.out.println("Asistente agregado exitosamente.");
            } else {
                System.out.println("Opción no válida.");
            }
        } else if (opcion.equalsIgnoreCase("baja")) {
            System.out.println("¿Es veterinario o asistente? (veterinario/asistente):");
            String tipo = scanner.nextLine();
            
            System.out.println("Ingrese el nombre:");
            String nombre = scanner.nextLine();
            
            if (tipo.equalsIgnoreCase("veterinario")) {
                Veterinario veterinario = gestionCitas.buscarVeterinario(nombre);
                if (veterinario != null) {
                    gestionCitas.eliminarVeterinario(veterinario);
                    System.out.println("Veterinario dado de baja exitosamente.");
                } else {
                    System.out.println("Veterinario no encontrado.");
                }
            } else if (tipo.equalsIgnoreCase("asistente")) {
                Asistente asistente = gestionCitas.buscarAsistente(nombre);
                if (asistente != null) {
                    gestionCitas.eliminarAsistente(asistente);
                    System.out.println("Asistente dado de baja exitosamente.");
                } else {
                    System.out.println("Asistente no encontrado.");
                }
            } else {
                System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void altaGerente(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("Ingrese el nombre del gerente:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese el apellido paterno del gerente:");
        String paterno = scanner.nextLine();
        
        System.out.println("Ingrese el apellido materno del gerente (o presione Enter si no tiene):");
        String materno = scanner.nextLine();
        if (materno.trim().isEmpty()) {
            materno = null;
        }
        
        System.out.println("Ingrese el número de gerente:");
        int numeroGerente = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        System.out.println("Ingrese el nombre de la sucursal:");
        String nombreSucursal = scanner.nextLine();
        
        System.out.println("Ingrese la zona de la sucursal:");
        String zonaSucursal = scanner.nextLine();
        
        Sucursal sucursal = new Sucursal(nombreSucursal, zonaSucursal);
        
        Gerente gerente = new Gerente(nombre, paterno, materno, null, null, numeroGerente, sucursal);
        gestionCitas.agregarGerente(gerente);
        
        System.out.println("Gerente agregado exitosamente.");
    }

    
    private static void registroCitas(GestionCitas gestionCitas, Scanner scanner) {
    System.out.println("Registro de Citas:");

    System.out.print("Ingrese el número de cliente: ");
    int numeroCliente = scanner.nextInt();
    scanner.nextLine();  // Consumir la nueva línea

    Cliente cliente = gestionCitas.buscarCliente(numeroCliente);
    if (cliente == null) {
        System.out.println("Cliente no encontrado.");
        return;
    }

    Mascota mascota = cliente.getMascota();

    System.out.print("Ingrese la fecha y hora de la cita (dd/MM/yyyy HH:mm): ");
    String fechaHoraStr = scanner.nextLine();
    Date fechaHora = null;
    try {
        fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(fechaHoraStr);
    } catch (Exception e) {
        System.out.println("Formato de fecha y hora incorrecto.");
        return;
    }

    if (!gestionCitas.revisarDisponibilidad(fechaHora)) {
        System.out.println("No puede agendar la cita, ya se encuentra ocupada.");
        return;
    }

    System.out.print("Ingrese la descripción del servicio: ");
    String descripcionServicio = scanner.nextLine();

    System.out.print("Ingrese los paquetes (separados por coma): ");
    String paquetesStr = scanner.nextLine();
    String[] paquetes = paquetesStr.split(",");

    // Seleccionar veterinario
    System.out.print("Ingrese el nombre del veterinario: ");
    String nombreVet = scanner.nextLine();
    Veterinario veterinario = gestionCitas.buscarVeterinario(nombreVet);
    if (veterinario == null) {
        System.out.println("Veterinario no encontrado.");
        return;
    }

    // Seleccionar asistente
    System.out.print("Ingrese el nombre del asistente: ");
    String nombreAsis = scanner.nextLine();
    Asistente asistente = gestionCitas.buscarAsistente(nombreAsis);
    if (asistente == null) {
        System.out.println("Asistente no encontrado.");
        return;
    }

    Cita cita = new Cita(gestionCitas.generarNumeroCita(), fechaHora, cliente, mascota, veterinario, asistente, descripcionServicio, paquetes);
    gestionCitas.agregarCita(cita);

    System.out.println("Cita registrada exitosamente.");
}

     private static void altaPaquetes(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("Ingrese el nombre del paquete:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese la descripción del paquete:");
        String descripcion = scanner.nextLine();
        
        System.out.println("Ingrese el precio del paquete:");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        
        Paquete paquete = new Paquete(nombre, descripcion, precio);
        gestionCitas.agregarPaquete(paquete);
        
        System.out.println("Paquete agregado exitosamente.");
    }

    private static void adopcionDevolucionMascotas(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("¿Desea adoptar o devolver una mascota? (adoptar/devolver):");
        String opcion = scanner.nextLine();
        
        if (opcion.equalsIgnoreCase("adoptar")) {
            System.out.println("Ingrese el número de la mascota que desea adoptar:");
            int numeroMascota = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            Mascota mascota = gestionCitas.buscarMascota(numeroMascota);
            if (mascota != null && !mascota.isAdoptada()) {
                gestionCitas.moverAMascotasAdoptadas(mascota);
                System.out.println("Mascota adoptada exitosamente.");
            } else if (mascota != null && mascota.isAdoptada()) {
                System.out.println("La mascota ya ha sido adoptada.");
            } else {
                System.out.println("Mascota no encontrada.");
            }
        } else if (opcion.equalsIgnoreCase("devolver")) {
            System.out.println("Ingrese el número de la mascota que desea devolver:");
            int numeroMascota = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            Mascota mascota = gestionCitas.buscarMascota(numeroMascota);
            if (mascota != null && mascota.isAdoptada()) {
                gestionCitas.devolverAMascotasGenerales(mascota);
                System.out.println("Mascota devuelta exitosamente.");
            } else if (mascota != null && !mascota.isAdoptada()) {
                System.out.println("La mascota no está adoptada.");
            } else {
                System.out.println("Mascota no encontrada.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }
    
    private static void pagoPaquetes(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("Ingrese el número de cliente:");
        int numeroCliente = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        Cliente cliente = gestionCitas.buscarCliente(numeroCliente);
        if (cliente != null) {
            System.out.println("Ingrese el número de la tarjeta:");
            long numeroTarjeta = scanner.nextLong();
            
            System.out.println("Ingrese la fecha de vencimiento de la tarjeta (formato: MM/yyyy):");
            int mes = scanner.nextInt();
            int anio = scanner.nextInt();
            
            System.out.println("Ingrese el número CVC de la tarjeta:");
            short cvc = scanner.nextShort();
            scanner.nextLine(); // Limpiar el buffer
            
            Date fechaVencimiento = new Date(anio - 1900, mes - 1, 1); // Ajuste para la fecha
            Tarjeta tarjeta = new Tarjeta(numeroTarjeta, fechaVencimiento, cvc);
            cliente.setTarjeta(tarjeta);
            
            System.out.println("Ingrese el número de paquetes que desea pagar:");
            int numPaquetes = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            double total = 0.0;
            for (int i = 0; i < numPaquetes; i++) {
                System.out.println("Ingrese el nombre del paquete " + (i + 1) + ":");
                String nombrePaquete = scanner.nextLine();
                
                Paquete paquete = gestionCitas.buscarPaquete(nombrePaquete);
                if (paquete != null) {
                    total += paquete.getPrecio();
                } else {
                    System.out.println("Paquete no encontrado.");
                }
            }
            
            tarjeta.setCargo(total);
            System.out.println("Pago realizado exitosamente. Total: $" + total);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }


     private static void consultaCitas(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("¿En qué orden desea ver el listado de citas? (fecha, nombreCliente, apellidoPaterno, apellidoMaterno):");
        String orden = scanner.nextLine();

        List<Cita> citas = gestionCitas.getCitas();
        Comparator<Cita> comparator = null;

        switch (orden.toLowerCase()) {
            case "fecha":
                comparator = Comparator.comparing(Cita::getFechaHora);
                break;
            case "nombrecliente":
                comparator = Comparator.comparing(cita -> cita.getCliente().getNombre());
                break;
            case "apellidopaterno":
                comparator = Comparator.comparing(cita -> cita.getCliente().getPaterno());
                break;
            case "apellidomaterno":
                comparator = Comparator.comparing(cita -> cita.getCliente().getMaterno());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        Collections.sort(citas, comparator);
        for (Cita cita : citas) {
            System.out.println(cita);
        }
    }

    private static void consultaPaquetes(GestionCitas gestionCitas, Scanner scanner) {
        List<Paquete> paquetes = gestionCitas.getPaquetes();
        for (Paquete paquete : paquetes) {
            System.out.println(paquete);
        }
    }

    private static void consultaAdopciones(GestionCitas gestionCitas, Scanner scanner) {
        List<Mascota> mascotasAdoptadas = gestionCitas.getMascotasAdoptadas();
        for (Mascota mascota : mascotasAdoptadas) {
            System.out.println(mascota);
        }
    }

    private static void consultaVeterinarios(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("¿En qué orden desea ver el listado de veterinarios? (nombre, apellidoPaterno, apellidoMaterno):");
        String orden = scanner.nextLine();

        List<Veterinario> veterinarios = gestionCitas.getVeterinarios();
        Comparator<Veterinario> comparator = null;

        switch (orden.toLowerCase()) {
            case "nombre":
                comparator = Comparator.comparing(Veterinario::getNombre);
                break;
            case "apellidopaterno":
                comparator = Comparator.comparing(Veterinario::getPaterno);
                break;
            case "apellidomaterno":
                comparator = Comparator.comparing(Veterinario::getMaterno);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        Collections.sort(veterinarios, comparator);
        for (Veterinario veterinario : veterinarios) {
            System.out.println(veterinario);
        }
    }

    private static void escrituraArchivoCitas(GestionCitas gestionCitas, Scanner scanner) {
        System.out.println("¿Desea escribir todas las citas o de una fecha específica? (todas/fecha):");
        String opcion = scanner.nextLine();

        List<Cita> citas = gestionCitas.getCitas();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (opcion.equalsIgnoreCase("fecha")) {
            System.out.println("Ingrese la fecha (yyyy-MM-dd):");
            String fechaStr = scanner.nextLine();
            Date fecha = null;
            try {
                fecha = sdf.parse(fechaStr);
            } catch (Exception e) {
                System.out.println("Fecha no válida.");
                return;
            }

            citas.removeIf(cita -> !sdf.format(cita.getFechaHora()).equals(fechaStr));
        } else if (!opcion.equalsIgnoreCase("todas")) {
            System.out.println("Opción no válida.");
            return;
        }

        System.out.println("Ingrese el nombre del archivo donde desea guardar las citas:");
        String nombreArchivo = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Cita cita : citas) {
                writer.write(cita.toString());
                writer.newLine();
            }
            System.out.println("Citas guardadas exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}



package remoteserver;

/*import java.rmi.Naming;
import java.util.Scanner;

public class RemoteClient {
    public static void main(String[] args) {
        try {
            RemoteInterface remoteObj = (RemoteInterface) Naming.lookup("//192.168.228.223:1099/RemoteService");
            Scanner scanner = new Scanner(System.in);

            System.out.print("¿Ya estás registrado? (Sí/No): ");
            String opcion = scanner.nextLine().toLowerCase();

            if (opcion.equals("si")) {
                // Inicio de sesión
                System.out.println("\nInicio de sesión:");
                System.out.print("Ingrese su nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String password = scanner.nextLine();

                if (remoteObj.autenticar(username, password)) {
                    System.out.println("Inicio de sesión exitoso.");
                } else {
                    System.out.println("Inicio de sesión fallido. \nVerifique sus credenciales "
                            + "\nEl Nombre esta ocupado ");
                }

            } else if (opcion.equals("no")) {
                // Registro de usuario
                System.out.println("\nRegistro de usuario:");
                System.out.print("Ingrese su nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String password = scanner.nextLine();

                if (remoteObj.registrarUsuario(username, password)) {
                    System.out.println("Registro exitoso.");
                } else {
                    System.out.println("Error al registrar el usuario. Verifique sus datos.");
                }

            } else {
                System.out.println("Opción no válida.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/

import java.rmi.Naming;
import java.util.Scanner;

public class RemoteClient {
    public static void main(String[] args) {
        try {
            // Conectar al servidor remoto
            String direccionServidor = "192.168.228.223"; // Cambia esta dirección por la del servidor remoto
            int puerto = 1099; // Puerto RMI
            String nombreServicio = "RemoteService"; // Nombre del servicio

            // Buscar el objeto remoto en el servidor
            RemoteInterface remoteObj = (RemoteInterface) Naming.lookup(String.format("//%s:%d/%s", direccionServidor, puerto, nombreServicio));
            
            // Resto del código del cliente (autenticación o registro de usuario)
            Scanner scanner = new Scanner(System.in);

            System.out.print("¿Ya estás registrado? (Sí/No): ");
            String opcion = scanner.nextLine().toLowerCase();

            if (opcion.equals("si")) {
                // Inicio de sesión
                System.out.println("\nInicio de sesión:");
                System.out.print("Ingrese su nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String password = scanner.nextLine();

                if (remoteObj.autenticar(username, password)) {
                    System.out.println("Inicio de sesión exitoso.");
                } else {
                    System.out.println("Inicio de sesión fallido. \nVerifique sus credenciales "
                            + "\nEl Nombre esta ocupado ");
                }

            } else if (opcion.equals("no")) {
                // Registro de usuario
                System.out.println("\nRegistro de usuario:");
                System.out.print("Ingrese su nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String password = scanner.nextLine();

                if (remoteObj.registrarUsuario(username, password)) {
                    System.out.println("Registro exitoso.");
                } else {
                    System.out.println("Error al registrar el usuario. Verifique sus datos.");
                }

            } else {
                System.out.println("Opción no válida.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


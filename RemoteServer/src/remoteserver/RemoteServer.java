package remoteserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class RemoteServer extends UnicastRemoteObject implements RemoteInterface {
    private static final String UR ="com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/loginrmi";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public RemoteServer() throws RemoteException {
        super();
    }

    @Override
    public boolean registrarUsuario(String username, String password) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO usuario (usuario_nombre, contraseña) VALUES (?, ?)")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
        

            int rowsAffected = preparedStatement.executeUpdate();
             // Devuelve true si el registro fue exitoso
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean autenticar(String username, String password) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE usuario_nombre = ? AND contraseña = ?")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            // Devuelve true si se encontró un usuario con las credenciales proporcionadas
            return resultSet.next(); 

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            // Iniciar el servicio RMI
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            RemoteInterface remoteObj = new RemoteServer();
            Naming.rebind("//localhost/RemoteService", remoteObj);
            System.out.println("Servicio RMI iniciado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*public static void main(String[] args) {
        try {
            // Iniciar el servicio RMI
            RemoteInterface remoteObj = new RemoteServer();
            String host = "192.168.223.228"; // Reemplaza con la dirección IP o el nombre del host del servidor remoto
            String serviceName = "//" + host + "/RemoteService";
            Naming.rebind(serviceName, remoteObj);
            System.out.println("Servicio RMI iniciado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

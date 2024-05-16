import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("127.0.0.1"); // Dirección IP del servidor
            int port = 12345;                                          // Puerto en el que el servidor está escuchando

            String message = "Hola desde el cliente UDP en Java";
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);
            System.out.println("Mensaje enviado desde el cliente UDP en Java");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}


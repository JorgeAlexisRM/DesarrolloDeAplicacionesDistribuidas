import socket

def main():
    # Creamos un objeto socket
    servidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    # Asociamos el servidor al puerto 12345
    servidor.bind(('localhost', 12345))
    
    # Escuchamos conexiones entrantes
    servidor.listen()
    print("Servidor escuchando en el puerto 12345...")
    
    # Aceptamos la conexión entrante
    cliente, direccion = servidor.accept()
    print("Conexión establecida desde:", direccion)
    
    # Recibimos el mensaje del cliente
    mensaje = cliente.recv(1024)
    print("Mensaje recibido del cliente:", mensaje.decode())
    
    # Devolvemos el mismo mensaje al cliente
    cliente.sendall(mensaje)
    
    # Cerramos la conexión
    cliente.close()

if __name__ == "__main__":
    main()

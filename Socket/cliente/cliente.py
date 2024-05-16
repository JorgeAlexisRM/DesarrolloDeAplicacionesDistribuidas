import socket

def main():
    # Creamos un objeto socket
    cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    # Conectamos el cliente al servidor en el puerto 12345
    servidor = ('localhost', 12345)
    cliente.connect(servidor)
    
    # Enviamos un mensaje al servidor
    mensaje = "¡Hola, servidor!"
    cliente.sendall(mensaje.encode())
    
    # Recibimos la respuesta del servidor
    respuesta = cliente.recv(1024)
    print("Respuesta del servidor:", respuesta.decode())
    
    # Cerramos la conexión
    cliente.close()

if __name__ == "__main__":
    main()

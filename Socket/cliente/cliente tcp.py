import socket

# Definir el host y el puerto del servidor al que se conectará el cliente
HOST = '192.168.228.239'  # Cambia esto por la dirección IP o el nombre del servidor
PUERTO = 65432  # Puerto en el que el servidor está escuchando

# Crear un objeto de socket TCP/IP
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as cliente:
    # Conectar al servidor
    cliente.connect((HOST, PUERTO))

    while True:
        # Enviar datos al servidor
        mensaje = input("Ingrese un mensaje para enviar al servidor: ")
        cliente.sendall(mensaje.encode())

        # Esperar la respuesta del servidor
        datos_recibidos = cliente.recv(1024)
        print('Datos recibidos del servidor:', datos_recibidos.decode())

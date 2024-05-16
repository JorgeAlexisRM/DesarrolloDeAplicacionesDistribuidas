import socket

# Definir el host y el puerto en el que el servidor escuchará
HOST = '0.0.0.0'  # Escucha en todas las interfaces disponibles
PUERTO = 65432  # Puerto para la conexión

# Crear un objeto de socket TCP/IP
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as servidor:
    # Enlace del socket a la dirección y el puerto
    servidor.bind((HOST, PUERTO))
    # Escuchar conexiones entrantes
    servidor.listen()

    print("Servidor TCP esperando conexiones...")

    # Aceptar la conexión entrante
    conexion, direccion = servidor.accept()

    with conexion:
        print('Conexión establecida desde:', direccion)
        while True:
            # Recibir datos del cliente
            datos = conexion.recv(1024)
            if not datos:
                break
            print('Datos recibidos del cliente:', datos.decode())
            # Enviar datos de vuelta al cliente
            conexion.sendall(datos)

import socket

UDP_IP = "127.0.0.1"    # Dirección IP del servidor
UDP_PORT = 12345        # Puerto en el que el servidor estará escuchando

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind((UDP_IP, UDP_PORT))

print("Servidor UDP iniciado")

while True:
    data, addr = sock.recvfrom(1024)
    print("Mensaje recibido:", data.decode())

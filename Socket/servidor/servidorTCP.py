import socket

HOST = '127.0.0.1'  # Dirección IP del servidor
PORT = 12345        # Puerto en el que el servidor estará escuchando

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print('Conexión establecida con', addr)
        while True:
            data = conn.recv(1024)
            if not data:
                break
            conn.sendall(data)

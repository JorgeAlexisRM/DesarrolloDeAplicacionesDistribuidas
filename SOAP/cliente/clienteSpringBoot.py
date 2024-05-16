import requests
import xml.etree.ElementTree as ET
import tkinter as tk
from tkinter import messagebox

# Función para enviar una solicitud SOAP al servidor
def send_soap_request(soap_body):
    url = 'http://localhost:8080/ws'  # URL del servidor
    headers = {'Content-Type': 'text/xml; charset=UTF-8'}  # Encabezados de la solicitud

    try:
        # Enviar la solicitud SOAP al servidor
        response = requests.post(url, data=soap_body, headers=headers)
        response_data = response.content.decode('UTF-8')
        
        # Analizar la respuesta SOAP
        root = ET.fromstring(response_data)
        product = root.find('.//{http://www.org.com/soap/gen}product')
        product_info = {
            'ID': product.find('{http://www.org.com/soap/gen}id').text,
            'Name': product.find('{http://www.org.com/soap/gen}name').text,
            'Price': product.find('{http://www.org.com/soap/gen}price').text,
            'Description': product.find('{http://www.org.com/soap/gen}description').text
        }
        
        # Mostrar la información del producto en una ventana emergente
        messagebox.showinfo('Producto Encontrado', f'ID: {product_info["ID"]}\nNombre: {product_info["Name"]}\nPrecio: {product_info["Price"]}\nDescripción: {product_info["Description"]}')
    except Exception as e:
        # Manejar errores de solicitud
        messagebox.showerror('Error', f'Error al enviar la solicitud: {str(e)}')

# Función para manejar la solicitud "Obtener Producto"
def get_product():
    soap_request = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gen="http://www.org.com/soap/gen">
        <soapenv:Header/>
        <soapenv:Body>
            <gen:getProductRequest>
                <gen:name>Arroz Costeño</gen:name>
            </gen:getProductRequest>
        </soapenv:Body>
    </soapenv:Envelope>"""
    send_soap_request(soap_request)

# Crear la ventana principal
root = tk.Tk()
root.title('Cliente SOAP')

# Crear un botón para obtener el producto
get_product_button = tk.Button(root, text='Obtener Producto', command=get_product)
get_product_button.pack(pady=20)

# Ejecutar la aplicación
root.mainloop()

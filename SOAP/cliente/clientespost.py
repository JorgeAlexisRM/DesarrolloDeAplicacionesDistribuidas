import tkinter as tk
from tkinter import messagebox
from zeep import Client
import uuid

# Crear el cliente SOAP
cliente = Client('http://localhost:8080/ws/products.wsdl')

def post_product():
    # Obtener los valores de los campos de entrada
    product_name = name_entry.get()
    product_price = price_entry.get()
    product_description = description_entry.get()

    product_id = 0

    # Construir el cuerpo de la solicitud SOAP utilizando Zeep
    soap_request = {
        'product': {
            'id': product_id,
            'name': product_name,
            'price': float(product_price),  # Convertir a float si es necesario
            'description': product_description
        }
    }

    try:
        # Enviar la solicitud al servicio
        resultado = cliente.service.postProduct(soap_request)
        messagebox.showinfo('Éxito', 'Producto insertado correctamente.')
    except Exception as e:
        messagebox.showerror('Error', f'Error al enviar la solicitud: {str(e)}')

# Crear la ventana principal
root = tk.Tk()
root.title('Insertar Producto')

# Crear los campos de entrada
name_label = tk.Label(root, text='Nombre del Producto:')
name_label.grid(row=0, column=0, padx=10, pady=5, sticky='e')
name_entry = tk.Entry(root)
name_entry.grid(row=0, column=1, padx=10, pady=5)

price_label = tk.Label(root, text='Precio:')
price_label.grid(row=1, column=0, padx=10, pady=5, sticky='e')
price_entry = tk.Entry(root)
price_entry.grid(row=1, column=1, padx=10, pady=5)

description_label = tk.Label(root, text='Descripción:')
description_label.grid(row=2, column=0, padx=10, pady=5, sticky='e')
description_entry = tk.Entry(root)
description_entry.grid(row=2, column=1, padx=10, pady=5)

# Crear el botón de enviar
post_button = tk.Button(root, text='Insertar Producto', command=post_product)
post_button.grid(row=3, column=0, columnspan=2, pady=10)

root.mainloop()

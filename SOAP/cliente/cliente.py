from zeep import Client
import tkinter as tk
from tkinter import messagebox

#crear el cliente
cliente = Client('http://localhost:8080/ws/products.wsdl')

def get_products():
    try:
        resultado = cliente.service.getProducts()
        messagebox.showinfo('Productos',resultado)
    except Exception as e:
        messagebox.showerror('Error', f'Error al enviar la solicitud: {str(e)}')

root = tk.Tk()
root.title('Cliente SOAP Python')

get_products_button = tk.Button(root,text='Mostrar Prodcutos', command=get_products)
get_products_button.pack(pady=20)

root.mainloop()
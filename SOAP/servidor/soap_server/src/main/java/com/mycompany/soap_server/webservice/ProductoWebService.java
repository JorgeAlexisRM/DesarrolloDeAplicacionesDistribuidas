/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soap_server.webservice;

import com.mycompany.soap_server.models.Producto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jarum
 */
public class ProductoWebService {
    public Double precioVenta(Double precio){
        return precio*1.5;
    }
    
    public Producto getProducto(Integer code){
        return new Producto(code,"Table",300.00,new Date());
    }
    
    public List<Producto> productoList(){
        return List.of(
                new Producto(1,"Table",300.00,new Date()),
                new Producto(2,"Table",300.00,new Date()),
                new Producto(3,"Table",300.00,new Date()),
                new Producto(4,"Table",300.00,new Date())
        );
    }
}

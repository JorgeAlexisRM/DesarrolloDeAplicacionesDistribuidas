/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soap_server.models;

import java.util.Date;

/**
 *
 * @author jarum
 */
public class Producto {
    private Integer code;
    private String name;
    private Double precio;
    private Date fechaCreacion;

    public Producto() {
    }

    public Producto(Integer code, String name, Double precio, Date fechaCreacion) {
        this.code = code;
        this.name = name;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author cybergato
 */
public class Compras {
    
    private String fechaCompra;
    private String correoUsuario, codigoCompra;
    private List<Multimedia> contenidoComprado;
    private List<EnlaceDescarga> listaEnlacesDescarga;
    private boolean estadoCompra; //indica si esta en carrito o ya fue comprada

    public Compras(String fechaCompra, String correoUsuario, String codigoCompra, List<Multimedia> contenidoComprado, List<EnlaceDescarga> listaEnlacesDescarga, boolean estadoCompra) {
        this.fechaCompra = fechaCompra;
        this.correoUsuario = correoUsuario;
        this.codigoCompra = codigoCompra;
        this.contenidoComprado = contenidoComprado;
        this.listaEnlacesDescarga = listaEnlacesDescarga;
        this.estadoCompra = estadoCompra;
    }
    
    public Compras(){}

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public List<Multimedia> getContenidoComprado() {
        return contenidoComprado;
    }

    public void setContenidoComprado(List<Multimedia> contenidoComprado) {
        this.contenidoComprado = contenidoComprado;
    }

    public List<EnlaceDescarga> getListaEnlacesDescarga() {
        return listaEnlacesDescarga;
    }

    public void setListaEnlacesDescarga(List<EnlaceDescarga> listaEnlacesDescarga) {
        this.listaEnlacesDescarga = listaEnlacesDescarga;
    }

    public boolean isEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(boolean estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author cybergato
 */
public class EnlaceDescarga {
    
    private String enlaceGenerado;
    private String fechaGeneracion, fechaDescarga, fechaExpiracion;
    private boolean estadoDescarga, estadoPenalizacion;
    private float penalizacion;

    public EnlaceDescarga(String enlaceGenerado, String fechaGeneracion, String fechaDescarga, String fechaExpiracion, boolean estadoDescarga, boolean estadoPenalizacion, float penalizacion) {
        this.enlaceGenerado = enlaceGenerado;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaDescarga = fechaDescarga;
        this.fechaExpiracion = fechaExpiracion;
        this.estadoDescarga = estadoDescarga;
        this.estadoPenalizacion = estadoPenalizacion;
        this.penalizacion = penalizacion;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getFechaDescarga() {
        return fechaDescarga;
    }

    public void setFechaDescarga(String fechaDescarga) {
        this.fechaDescarga = fechaDescarga;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    
    
    
    public EnlaceDescarga(){}

    public String getEnlaceGenerado() {
        return enlaceGenerado;
    }

    public void setEnlaceGenerado(String enlaceGenerado) {
        this.enlaceGenerado = enlaceGenerado;
    }

    public boolean isEstadoDescarga() {
        return estadoDescarga;
    }

    public void setEstadoDescarga(boolean estadoDescarga) {
        this.estadoDescarga = estadoDescarga;
    }

    public boolean isEstadoPenalizacion() {
        return estadoPenalizacion;
    }

    public void setEstadoPenalizacion(boolean estadoPenalizacion) {
        this.estadoPenalizacion = estadoPenalizacion;
    }

    public float getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(float penalizacion) {
        this.penalizacion = penalizacion;
    }
    
}

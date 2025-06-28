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
    private Date fechaGeneracion, fechaDescarga, fechaExpiracion;
    private boolean estadoDescarga, estadoPenalizacion;
    private float penalizacion;

    public EnlaceDescarga(){}
    
    public EnlaceDescarga(String enlaceGenerado, Date fechaGeneracion, Date fechaDescarga, Date fechaExpiracion, boolean estadoDescarga, boolean estadoPenalizacion, float penalizacion) {
        this.enlaceGenerado = enlaceGenerado;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaDescarga = fechaDescarga;
        this.fechaExpiracion = fechaExpiracion;
        this.estadoDescarga = estadoDescarga;
        this.estadoPenalizacion = estadoPenalizacion;
        this.penalizacion = penalizacion;
    }

    public String getEnlaceGenerado() {
        return enlaceGenerado;
    }

    public void setEnlaceGenerado(String enlaceGenerado) {
        this.enlaceGenerado = enlaceGenerado;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaDescarga() {
        return fechaDescarga;
    }

    public void setFechaDescarga(Date fechaDescarga) {
        this.fechaDescarga = fechaDescarga;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
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

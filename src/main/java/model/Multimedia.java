/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.json.JSONObject;

/**
 *
 * @author cybergato
 */
public class Multimedia {
    
    private String titulo, generos, urlPortada;
    private int anio;
    private float precio;
    
    public Multimedia(){}

    public Multimedia(String titulo, String generos, String urlPortada, int anio, float precio) {
        this.titulo = titulo;
        this.generos = generos;
        this.urlPortada = urlPortada;
        this.anio = anio;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public JSONObject toJSON() {
        return null;
    }

}

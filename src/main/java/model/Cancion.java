/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * 
 * 
 * @author cybergato
 */
public class Cancion extends Multimedia{
    
    private String formato, edicion, artistas, sello, urlCancion;
    private int duracion;
    
    public Cancion(){}

    public Cancion(int duracion, String formato, String edicion, String genero, String sello, String artistas, String titulo, String generos, String urlPortada, int anio, float precio, String urlCancion) {
        super(titulo, generos, urlPortada, anio, precio);
        this.duracion = duracion;
        this.formato = formato;
        this.edicion = edicion;
        this.artistas = artistas;
        this.sello = sello;
        this.urlCancion = urlCancion;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getUrlCancion() {
        return urlCancion;
    }

    public void setUrlCancion(String urlCancion) {
        this.urlCancion = urlCancion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("tipoMultimedia", "Cancion");
        json.put("titulo", getTitulo());
        json.put("generos", getGeneros());
        json.put("urlPortada", getUrlPortada());
        json.put("anio", getAnio());
        json.put("precio", getPrecio());
        json.put("formato", getFormato());
        json.put("edicion", getEdicion());
        json.put("artistas", getArtistas());
        json.put("selloDiscografico", getSello());
        json.put("duracion", getDuracion());
        json.put("urlCancion", getUrlCancion());
        return json;
    }



}

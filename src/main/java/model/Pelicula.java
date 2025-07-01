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
public class Pelicula extends Multimedia{
    
    private Album soundtrack;
    private String director, casaProductora, formato, sinopsis, actores, duracion;

    public Pelicula() {
    }


    public Pelicula(String director, String casaProductora, String formato, String sinopsis, String actores, String duracion, String titulo, String generos, String urlPortada, int anio, float precio) {
        super(titulo, generos, urlPortada, anio, precio);
        this.soundtrack = soundtrack;
        this.director = director;
        this.casaProductora = casaProductora;
        this.formato = formato;
        this.sinopsis = sinopsis;
        this.actores = actores;
        this.duracion = duracion;
    }
    
    public Pelicula(Album soundtrack, String director, String casaProductora, String formato, String sinopsis, String actores, String duracion) {
        this.soundtrack = soundtrack;
        this.director = director;
        this.casaProductora = casaProductora;
        this.formato = formato;
        this.sinopsis = sinopsis;
        this.actores = actores;
        this.duracion = duracion;
    }

    public Album getSoundtrack() {
        return soundtrack;
    }

    public void setSoundtrack(Album soundtrack) {
        this.soundtrack = soundtrack;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCasaProductora() {
        return casaProductora;
    }

    public void setCasaProductora(String casaProductora) {
        this.casaProductora = casaProductora;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("tipoMultimedia", "Pelicula");
        json.put("titulo", getTitulo());
        json.put("generos", getGeneros());
        json.put("urlPortada", getUrlPortada());
        json.put("anio", getAnio());
        json.put("precio", getPrecio());
        json.put("duracion", getDuracion());
        json.put("formato", getFormato());
        json.put("director", getDirector());
        json.put("casaProductora", getCasaProductora());
        return json;
    }


}
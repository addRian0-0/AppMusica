/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author cybergato
 */
public class Pelicula extends Multimedia{
    
    private Album soundtrack;
    private String director, casaProductora, formato, sinopsis, actores, duracion;

    public Pelicula(Album soundtrack, String director, String casaProductora, String formato, String sinopsis, String actores, String duracion) {
        this.soundtrack = soundtrack;
        this.director = director;
        this.casaProductora = casaProductora;
        this.formato = formato;
        this.sinopsis = sinopsis;
        this.actores = actores;
        this.duracion = duracion;
    }

    public Pelicula(Album soundtrack, String director, String casaProductora, String formato, String sinopsis, String actores, String duracion, String titulo, String generos, String urlPortada, int anio, float precio) {
        super(titulo, generos, urlPortada, anio, precio);
        this.soundtrack = soundtrack;
        this.director = director;
        this.casaProductora = casaProductora;
        this.formato = formato;
        this.sinopsis = sinopsis;
        this.actores = actores;
        this.duracion = duracion;
    }
    
}

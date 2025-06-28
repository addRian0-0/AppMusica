/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author cybergato
 */
public class Capitulos extends Multimedia{
    
    private int numCapitulo, numTemporada, duracion;
    private String sinopsis;
    
    public Capitulos(){}

    public Capitulos(int numCapitulo, int numTemporada, int duracion, String sinopsis, String titulo, String generos, String urlPortada, int anio, float precio) {
        super(titulo, generos, urlPortada, anio, precio);
        this.numCapitulo = numCapitulo;
        this.numTemporada = numTemporada;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }

    public int getNumCapitulo() {
        return numCapitulo;
    }

    public void setNumCapitulo(int numCapitulo) {
        this.numCapitulo = numCapitulo;
    }

    public int getNumTemporada() {
        return numTemporada;
    }

    public void setNumTemporada(int numTemporada) {
        this.numTemporada = numTemporada;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    
}

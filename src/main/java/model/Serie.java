/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author cybergato
 */
public class Serie extends Multimedia{
    
    private String formato, director, casaProductora, sinopsis;
    private int temporadas;
    private List<Capitulos> listaCapitulos;
    
    public Serie(){}

    public Serie(String formato, String director, String casaProductora, String sinopsis, int temporadas, List<Capitulos> listaCapitulos, String titulo, String generos, String urlPortada, int anio, float precio) {
        super(titulo, generos, urlPortada, anio, precio);
        this.formato = formato;
        this.director = director;
        this.casaProductora = casaProductora;
        this.sinopsis = sinopsis;
        this.temporadas = temporadas;
        this.listaCapitulos = listaCapitulos;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
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

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public List<Capitulos> getListaCapitulos() {
        return listaCapitulos;
    }

    public void setListaCapitulos(List<Capitulos> listaCapitulos) {
        this.listaCapitulos = listaCapitulos;
    }
    
}

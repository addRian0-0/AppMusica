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
public class Album extends Multimedia{
    
    private String artistas, selloDiscografico, tipo;
    private List<Cancion> cancionesAlbum;

    public Album(){}
    
    public Album(String artistas, String selloDiscografico, String tipo, List<Cancion> cancionesAlbum, String titulo, String generos, String urlPortada, int anio, float precio) {
        super(titulo, generos, urlPortada, anio, precio);
        this.artistas = artistas;
        this.selloDiscografico = selloDiscografico;
        this.tipo = tipo;
        this.cancionesAlbum = cancionesAlbum;
    }
    
    public Album( String titulo, String generos, String urlPortada, int anio, float precio, String artistas){
        super(titulo, generos,urlPortada, anio, precio);
        this.artistas = artistas;
    }
    
    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public String getSelloDiscografico() {
        return selloDiscografico;
    }

    public void setSelloDiscografico(String selloDiscografico) {
        this.selloDiscografico = selloDiscografico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Cancion> getCancionesAlbum() {
        return cancionesAlbum;
    }

    public void setCancionesAlbum(List<Cancion> cancionesAlbum) {
        this.cancionesAlbum = cancionesAlbum;
    }
    
    
    
}

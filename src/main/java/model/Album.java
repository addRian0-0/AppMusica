/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 *
 * @author cybergato
 */
public class Album extends Multimedia{
    
    private String artistas, selloDiscografico, tipo;
    private List<Cancion> cancionesAlbum;
    private String idAlbum;


    public Album(){}

    public Album(String idAlbum, String artistas, String selloDiscografico, String tipo, List<Cancion> cancionesAlbum, String titulo, String generos, String urlPortada, int anio, float precio) {
        super(titulo, generos, urlPortada, anio, precio);
        this.idAlbum = idAlbum;
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

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("tipoMultimedia", "Album");
        json.put("titulo", getTitulo());
        json.put("generos", getGeneros());
        json.put("urlPortada", getUrlPortada());
        json.put("anio", getAnio());
        json.put("precio", getPrecio());
        json.put("artistas", getArtistas());
        json.put("selloDiscografico", getSelloDiscografico());
        json.put("cancionesAlbum", new JSONArray(getCancionesAlbum())); // asumiendo que es List<String>
        return json;
    }


}

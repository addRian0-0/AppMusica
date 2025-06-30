package DAO;

import model.Album;
import model.Cancion;

import java.util.ArrayList;
import java.util.List;

public class CarritoDAO {
    // Lista estática (carrito global)
    private static final List<Cancion> canciones = new ArrayList<>();

    private static final List<Album> albums = new ArrayList<>();

    // Métodos estáticos
    public static void agregarCancion(Cancion c) {
        canciones.add(c);
    }

    public static List<Cancion> getCanciones() {
        return canciones;
    }

    public static void agregarAlbum(Album a){albums.add(a);}

    public static List<Album> getAlbums(){return albums;}
}

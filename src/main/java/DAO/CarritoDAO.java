package DAO;

import model.*;

import java.util.*;

public class CarritoDAO {
    private static final List<Object> listaVisual = new ArrayList<>();

    private static final Set<String> albumesVisuales = new HashSet<>();

    public static final List<Multimedia> listaMultimedia = new ArrayList<>();

    public static List<Multimedia> getListaMultimedia() {
        return listaMultimedia;
    }

    public static void agregarMultimedia(Multimedia multimedia){
        listaMultimedia.add(multimedia); // canciones, películas, etc.
    }

    public static void agregarVisualmente(Album album) {
        if (!albumesVisuales.contains(album.getIdAlbum())) {
            listaVisual.add(album); // solo para mostrar
            albumesVisuales.add(album.getIdAlbum());
        }
    }


    public static List<Object> getItems() {
        return listaVisual; // solo los álbumes visuales
    }

    public static void limpiar() {
        listaMultimedia.clear();
        listaVisual.clear();
        albumesVisuales.clear();
    }

}

package DAO;

import model.*;

import java.util.*;

public class CarritoDAO {
    // Lista estática (carrito global)
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
            listaVisual.add(album); // se muestra solo el álbum
            albumesVisuales.add(album.getIdAlbum());
        }
    }

    public static List<Object> getItems() {
        return Collections.singletonList(listaMultimedia);
    }

    public static void limpiar() {
        listaMultimedia.clear();
        listaVisual.clear();
        albumesVisuales.clear();
    }

}

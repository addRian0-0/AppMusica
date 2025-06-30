package DAO;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class CarritoDAO {
    // Lista estática (carrito global)
    private static final List<Cancion> canciones = new ArrayList<>();

    public static final List<Multimedia> listaMultimedia = new ArrayList<>();

    public static List<Multimedia> getListaMultimedia() {
        return listaMultimedia;
    }

    public static List<Multimedia> agregarMultimedia(Multimedia multimedia){

        listaMultimedia.add(multimedia);
        return listaMultimedia;
    }

}

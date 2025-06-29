package interfaces;

import model.Cancion;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    // Lista estática (carrito global)
    private static final List<Cancion> canciones = new ArrayList<>();

    // Métodos estáticos
    public static void agregarCancion(Cancion c) {
        canciones.add(c);
    }

    public static List<Cancion> getCanciones() {
        return canciones;
    }
}

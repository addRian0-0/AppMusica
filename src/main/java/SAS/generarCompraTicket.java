package SAS;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.Cancion;
import model.Multimedia;
import model.Pelicula;
import model.Serie;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

public class generarCompraTicket {

    private static int contador;

    public static JSONObject generarCompra(String correoUsuario, List<Cancion> carrito) {
        if (contador == 0) {
            contador = 1;
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String fechaActual = LocalDateTime.now().format(formato);
        String codigoCompra = String.format("CDC%06d", contador++);

        JSONArray contenidoComprado = new JSONArray();
        for (Cancion cancion : carrito) {
            JSONObject jsonCancion = new JSONObject();
            jsonCancion.put("titulo", cancion.getTitulo());
            jsonCancion.put("generos", cancion.getGeneros());
            jsonCancion.put("urlPortada", cancion.getUrlPortada());
            jsonCancion.put("anio", cancion.getAnio());
            jsonCancion.put("precio", cancion.getPrecio());
            jsonCancion.put("artistas", cancion.getArtistas());
            jsonCancion.put("selloDiscografico", cancion.getSello());
            jsonCancion.put("tipo", cancion.getEdicion());
            jsonCancion.put("cancionesAlbum", new JSONArray());
            contenidoComprado.put(jsonCancion);
        }

        JSONArray listaEnlacesDescarga = new JSONArray();
        JSONObject enlace = new JSONObject();
        enlace.put("enlaceGenerado", "https://descargas.example.com/" + codigoCompra + "/1");
        enlace.put("fechaGeneracion", fechaActual);
        enlace.put("fechaDescarga", JSONObject.NULL);
        enlace.put("fechaExpiracion", LocalDateTime.now().plusDays(7).format(formato));
        enlace.put("estadoDescarga", false);
        enlace.put("estadoPenalizacion", true);
        enlace.put("penalizacion", 5.0);
        listaEnlacesDescarga.put(enlace);

        JSONObject compra = new JSONObject();
        compra.put("fechaCompra", fechaActual);
        compra.put("correoUsuario", correoUsuario);
        compra.put("codigoCompra", codigoCompra);
        compra.put("contenidoComprado", contenidoComprado);
        compra.put("listaEnlacesDescarga", listaEnlacesDescarga);
        compra.put("estadoCompra", true);

        return compra;
    }

    public static void guardarCompra(JSONObject compra) {
        String filename = "data/compras.json";
        JSONArray comprasArray = new JSONArray();

        // Lee historial existente, si hay
        try {
            File file = new File(filename);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                reader.close();
                if (!sb.toString().isEmpty()) {
                    comprasArray = new JSONArray(sb.toString());
                }
            }
        } catch (Exception e) {
            // Si algo falla leyendo, solo crea un nuevo array vacío
            comprasArray = new JSONArray();
        }

        // Agrega la nueva compra al historial
        comprasArray.put(compra);

        // Escribe de regreso el historial actualizado
        try (FileWriter file = new FileWriter(filename)) {
            file.write(comprasArray.toString(4)); // Pretty print
            file.flush();
            System.out.println("Compra registrada en historial correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


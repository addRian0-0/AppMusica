package SAS;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.Cancion;
import model.Multimedia;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import model.Pelicula;
import model.Serie;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import utils.ConfigLoader;

import java.util.Properties;

public class generarCompraTicket {

    private static int contador;

    public static JSONObject generarCompra(String correoUsuario, List<Multimedia> carrito) {
        if (contador == 0) contador = 1;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String fechaActual = LocalDateTime.now().format(formato);
        String codigoCompra = String.format("CDC%06d", contador++);

        JSONArray contenidoComprado = new JSONArray();
        for (Multimedia item : carrito) {
            contenidoComprado.put(item.toJSON()); // Polimorfismo: cada clase sabe cómo representarse
        }
        JSONArray listaEnlacesDescarga = new JSONArray();

        // Parámetros de Azure (ajústalos a tu entorno)
        String connectionString = ConfigLoader.get("azure.connectionString");
        String containerName = ConfigLoader.get("azure.containerName");

        for (Multimedia item : carrito) {
            contenidoComprado.put(item.toJSON());

            String enlaceGenerado = "N/A";

            if (item instanceof Cancion) {
                Cancion cancion = (Cancion) item;
                String url = cancion.getUrlCancion();

                try {
                    // Obtener blobName limpio y decodificado
                    URL azureUrl = new URL(url);
                    String path = azureUrl.getPath(); // Ej: "/canciones/05%20-%20Deftones%20-%20Rickets.mp3"
                    String blobName = path.replaceFirst("/" + containerName + "/", "");
                    blobName = URLDecoder.decode(blobName, StandardCharsets.UTF_8); // "05 - Deftones - Rickets.mp3"

                    // Generar SAS
                    enlaceGenerado = AzureSAS.generateDownloadSAS(connectionString, containerName, blobName);
                } catch (Exception e) {
                    System.out.println(" Error generando SAS para: " + url);
                    e.printStackTrace();
                }
            }


            JSONObject enlace = new JSONObject();
            enlace.put("enlaceGenerado", enlaceGenerado);
            enlace.put("fechaGeneracion", fechaActual);
            enlace.put("fechaDescarga", JSONObject.NULL);
            enlace.put("fechaExpiracion", LocalDateTime.now().plusDays(7).format(formato));
            enlace.put("estadoDescarga", false);
            enlace.put("estadoPenalizacion", false);
            listaEnlacesDescarga.put(enlace);
        }

        JSONObject compra = new JSONObject();
        compra.put("fechaCompra", fechaActual);
        compra.put("correoUsuario", correoUsuario);
        compra.put("codigoCompra", codigoCompra);
        compra.put("contenidoComprado", contenidoComprado);
        compra.put("listaEnlacesDescarga", listaEnlacesDescarga);
        compra.put("estadoCompra", true);

        return compra;
    }


    public static void guardarCompra(JSONObject compra, String correo) {
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
        CorreoUtil.enviarCorreo(correo, "Compra de contenido", compra.toString(4));

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


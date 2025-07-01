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
import java.util.HashMap;
import java.util.List;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import utils.ConfigLoader;
import java.util.Map;
import java.util.Properties;

import SAS.UsuarioDAO;


public class generarCompraTicket {

    private static int contador;

    public static JSONObject generarCompra(String correoUsuario, List<Multimedia> carrito) {
        if (contador == 0) contador = 1;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String fechaActual = LocalDateTime.now().format(formato);
        String codigoCompra = String.format("CDC%06d", contador++);

        JSONArray contenidoComprado = new JSONArray();
        JSONArray listaEnlacesDescarga = new JSONArray();

        String connectionString = ConfigLoader.get("azure.connectionString");
        String containerName = ConfigLoader.get("azure.containerName");

        for (Multimedia item : carrito) {
            contenidoComprado.put(item.toJSON());
            String enlaceGenerado = "N/A";

            if (item instanceof Cancion) {
                Cancion cancion = (Cancion) item;
                String url = cancion.getUrlCancion();

                try {
                    URL azureUrl = new URL(url);
                    String path = azureUrl.getPath();
                    String blobName = path.replaceFirst("/" + containerName + "/", "");
                    blobName = URLDecoder.decode(blobName, StandardCharsets.UTF_8);

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

    public static String generarHtmlCanciones(JSONArray contenidoComprado) {
        StringBuilder htmlBuilder = new StringBuilder();
        for (int i = 0; i < contenidoComprado.length(); i++) {
            JSONObject item = contenidoComprado.getJSONObject(i);
            String titulo = item.optString("titulo", "Sin título");
            String artistas = item.optString("artistas", "Desconocido");
            String genero = item.optString("generos", "No especificado");
            String urlPortada = item.optString("urlPortada", "");
            int anio = item.optInt("anio", 0);
            float precio = (float) item.optDouble("precio", 0);
            String urlCancion = item.optString("urlCancion", "#");

            htmlBuilder.append("<div style=\"margin-bottom: 30px; padding: 20px; background-color: #2c1f2e; border-radius: 12px; color: white; text-align: center; max-width: 500px; margin-left: auto; margin-right: auto;\">");
            htmlBuilder.append("<img src=\"").append(urlPortada).append("\" alt=\"Portada\" style=\"width: 200px; height: auto; border-radius: 8px; margin-bottom: 10px;\"><br>");
            htmlBuilder.append("<strong style=\"font-size: 22px;\">").append(titulo).append("</strong><br>");
            htmlBuilder.append("Artista(s): ").append(artistas).append("<br>");
            htmlBuilder.append("Género: ").append(genero).append("<br>");
            htmlBuilder.append("Año: ").append(anio).append("<br>");
            htmlBuilder.append("Precio: $").append(precio).append("<br><br>");
            htmlBuilder.append("<a href=\"").append(urlCancion).append("\" style=\"display:inline-block;background-color:#9e4ed3;color:white;padding:10px 16px;border-radius:5px;text-decoration:none;\">Link de descarga</a>");
            htmlBuilder.append("</div>");
        }
        return htmlBuilder.toString();
    }

    public static void guardarCompra(JSONObject compra, String correo) {
        String filename = "data/compras.json";
        JSONArray comprasArray = new JSONArray();


        String usuario = UsuarioDAO.obtenerUsuarioPorCorreo(correo);

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
            comprasArray = new JSONArray();
        }

        JSONArray enlaces = compra.getJSONArray("listaEnlacesDescarga");
        if (enlaces.length() > 0) {
            JSONObject enlace = enlaces.getJSONObject(0);
            String htmlCanciones = generarHtmlCanciones(compra.getJSONArray("contenidoComprado"));

            Map<String, String> datos = new HashMap<>();
            datos.put("usuario", usuario);
            datos.put("correoUsuario", correo);
            datos.put("codigoCompra", compra.optString("codigoCompra", "—"));
            datos.put("enlaceGenerado", enlace.getString("enlaceGenerado"));
            datos.put("fechaGeneracion", enlace.getString("fechaGeneracion"));
            datos.put("fechaDescarga", enlace.opt("fechaDescarga") == JSONObject.NULL ? "—" : enlace.getString("fechaDescarga"));
            datos.put("fechaExpiracion", enlace.getString("fechaExpiracion"));
            datos.put("estadoDescarga", String.valueOf(enlace.getBoolean("estadoDescarga")));
            datos.put("estadoPenalizacion", String.valueOf(enlace.getBoolean("estadoPenalizacion")));
            datos.put("canciones_html", htmlCanciones);

            comprasArray.put(compra);

            String plantilla = CorreoUtil.cargarHtml("src/main/java/SAS/index.html");
            String htmlConDatos = CorreoUtil.rellenarPlantilla(plantilla, datos);
            CorreoUtil.enviarCorreo(correo, "Compra de contenido", htmlConDatos);
        }

        try (FileWriter file = new FileWriter(filename)) {
            file.write(comprasArray.toString(4));
            file.flush();
            System.out.println("Compra registrada en historial correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
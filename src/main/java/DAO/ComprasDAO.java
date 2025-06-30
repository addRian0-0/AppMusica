/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import model.Compras;
import model.EnlaceDescarga;
import model.Multimedia;

/**
 *
 * @author PC
 */
public class ComprasDAO {

    public List<Compras> getCompras(String correo) {
        List<Compras> comprasCompletadas = new ArrayList<>();

        try {
            FileReader reader = new FileReader("data/compras.json");
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Compras>>() {}.getType();
            List<Compras> todasLasCompras = gson.fromJson(reader, listType);
            reader.close();

            for (Compras compra : todasLasCompras) {
                if (compra.isEstadoCompra() && compra.getCorreoUsuario().equalsIgnoreCase(correo)) {
                    comprasCompletadas.add(compra);
                }
            }

            imprimirCompras(comprasCompletadas);

        } catch (Exception e) {
            System.out.println("Error al leer compras completadas: " + e.getMessage());
        }

        return comprasCompletadas;
    }


    public List<Compras> getCarrito() {
        List<Compras> comprasEnCarrito = new ArrayList<>();

        try {
            FileReader reader = new FileReader("data/compras.json");
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Compras>>() {
            }.getType();
            List<Compras> todasLasCompras = gson.fromJson(reader, listType);
            reader.close();

            for (Compras compra : todasLasCompras) {
                if (!compra.isEstadoCompra()) {
                    comprasEnCarrito.add(compra);
                }
            }
            
            imprimirCompras(comprasEnCarrito);

        } catch (Exception e) {
            System.out.println("Error al leer compras en carrito: " + e.getMessage());
        }

        return comprasEnCarrito;
    }

    public void imprimirCompras(List<Compras> lista) {
        for (Compras compra : lista) {
            System.out.println("===== COMPRA =====");
            System.out.println("Correo usuario: " + compra.getCorreoUsuario());
            System.out.println("Código de compra: " + compra.getCodigoCompra());
            System.out.println("Fecha de compra: " + compra.getFechaCompra());
            System.out.println("Estado de compra: " + (compra.isEstadoCompra() ? "COMPLETADA" : "EN CARRITO"));

            System.out.println("\n--- Contenido Comprado ---");
            for (Multimedia m : compra.getContenidoComprado()) {
                System.out.println("Tipo: " + m.getClass().getSimpleName());
                System.out.println("Título: " + m.getTitulo());
                System.out.println("Géneros: " + m.getGeneros());
                System.out.println("Año: " + m.getAnio());
                System.out.println("Precio: $" + m.getPrecio());
                System.out.println("URL Portada: " + m.getUrlPortada());
                System.out.println("----------------------");
            }

            System.out.println("\n--- Enlaces de Descarga ---");
            for (EnlaceDescarga enlace : compra.getListaEnlacesDescarga()) {
                System.out.println("Enlace: " + enlace.getEnlaceGenerado());
                System.out.println("Generado: " + enlace.getFechaGeneracion());
                System.out.println("Descargado: " + enlace.getFechaDescarga());
                System.out.println("Expira: " + enlace.getFechaExpiracion());
                System.out.println("Estado descarga: " + (enlace.isEstadoDescarga() ? "DESCARGADO" : "PENDIENTE"));
                System.out.println("Penalización activa: " + (enlace.isEstadoPenalizacion() ? "Sí" : "No"));
                System.out.println("Monto penalización: $" + enlace.getPenalizacion());
                System.out.println("----------------------");
            }

            System.out.println("===========================\n");
        }
    }

}

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
            
        } catch (Exception e) {
            System.out.println("Error al leer compras en carrito: " + e.getMessage());
        }

        return comprasEnCarrito;
    }

}

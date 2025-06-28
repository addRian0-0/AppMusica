/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Pelicula;

/**
 *
 * @author PC
 */
public class PeliculasDAO {
    
    public List<Pelicula> getPeliculas() {
        List<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            FileReader reader = new FileReader("data/peliculas.json");

            Gson gson = new Gson();
            java.lang.reflect.Type peliculaListType = new TypeToken<List<Pelicula>>() {}.getType();
            listaPeliculas = gson.fromJson(reader, peliculaListType);

            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo JSON de películas: " + e.getMessage());
        }

        return listaPeliculas;
    }
    
}

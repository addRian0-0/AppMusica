/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bd.Conexion;
import model.Pelicula;

public class PeliculasDAO {

    public List<Pelicula> getPeliculas1() {

        List<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            Connection conn = Conexion.getConnection();

            String query = "SELECT ID_PELICULA_SERIE, TITULO, GENERO, ANIO_ESTRENO, FORMATO, DIRECTOR, PRODUCTORA, ID_ALBUM_SOUNDTRACK,sinopsis,duracion,urlPortada,precio FROM PELICULAS_SERIES";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                float precio = rs.getInt("precio");
                String urlPortada = rs.getString("urlportada");
                int duracion= rs.getInt("duracion");
                String duracionString = String.valueOf(duracion);
                String sinopsis = rs.getString("sinopsis");
                String id = rs.getString("ID_PELICULA_SERIE");
                String titulo = rs.getString("TITULO");
                String genero = rs.getString("GENERO");
                int anio = rs.getInt("ANIO_ESTRENO");
                String formato = rs.getString("FORMATO");
                String director = rs.getString("DIRECTOR");
                String productora = rs.getString("PRODUCTORA");
                String idAlbum = rs.getString("ID_ALBUM_SOUNDTRACK");

                Pelicula pelicula = new Pelicula(director,productora,formato,sinopsis,"",duracionString,titulo,genero,urlPortada,anio,precio);

                listaPeliculas.add(pelicula);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al obtener películas: " + e);
        }

        return listaPeliculas;
    }
}


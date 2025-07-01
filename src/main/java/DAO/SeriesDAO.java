/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import bd.Conexion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Serie;

/**
 *
 * @author PC
 */
public class SeriesDAO {

    public List<Serie> getSeries() {
        List<Serie> listaSeries = new ArrayList<>();

        try {
            Connection conn = Conexion.getConnection();

            String query = "SELECT titulo, generos, urlPortada, precio, anio, formato, director, casaProductora, sinopsis, temporadas FROM SERIES";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String generos = rs.getString("generos");
                String urlPortada = rs.getString("urlPortada");
                float precio = rs.getFloat("precio");
                int anio = rs.getInt("anio");
                String formato = rs.getString("formato");
                String director = rs.getString("director");
                String casaProductora = rs.getString("casaProductora");
                String sinopsis = rs.getString("sinopsis");
                int temporadas = rs.getInt("temporadas");

                Serie serieAdd = new Serie(formato,director,casaProductora,sinopsis,temporadas,"",titulo,generos,urlPortada,anio,precio);

                listaSeries.add(serieAdd);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al conectar la BD o al consultar SERIES: " + e);
        }

        return listaSeries;
    }


}

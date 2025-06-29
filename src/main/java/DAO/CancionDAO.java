/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import bd.Conexion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.ProcessBuilder.Redirect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Album;
import model.Cancion;

/**
 *
 * @author cybergato
 */
public class CancionDAO {

    public List<Cancion> getPistas1() {

        List<Cancion> listaCanciones = new ArrayList<>();
        try {

            Connection conn = Conexion.getConnection();

            String query = "SELECT TIPO_PISTA, NOMBRE_ARTISTA, ID_ALBUM, SELLO_DISCOGRAFICO, FORMATO, EDICION, NOMBRE_PISTA, GENERO, URL_ICONO, URL_PISTA FROM PISTAS";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String tipoPista = rs.getString("TIPO_PISTA");
                String nombreArtista = rs.getString("NOMBRE_ARTISTA");
                String selloDiscografico = rs.getString("SELLO_DISCOGRAFICO");
                String formato = rs.getString("FORMATO");
                String edicion = rs.getString("EDICION");
                String nombrePista = rs.getString("NOMBRE_PISTA");
                String genero = rs.getString("GENERO");
                String urlPortada = rs.getString("URL_ICONO");
                String urlCancion = rs.getString("URL_PISTA");

                Cancion cancionAdd = new Cancion(0, formato, edicion, genero, selloDiscografico, nombreArtista, nombrePista, "Generos default", urlPortada, 2000, 0, urlCancion);

                listaCanciones.add(cancionAdd);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al conectar la BD: " + e);
        }

        return listaCanciones;

    }

    public List<Cancion> getCancionesPorAlbum(String idAlbum) {
        List<Cancion> listaCanciones = new ArrayList<>();
        try {
            Connection conn = Conexion.getConnection();
            String query = "SELECT TIPO_PISTA, NOMBRE_ARTISTA, ID_ALBUM, SELLO_DISCOGRAFICO, FORMATO, EDICION, NOMBRE_PISTA, GENERO, URL_ICONO, URL_PISTA FROM PISTAS WHERE ID_ALBUM = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idAlbum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String tipoPista = rs.getString("TIPO_PISTA");
                String nombreArtista = rs.getString("NOMBRE_ARTISTA");
                String selloDiscografico = rs.getString("SELLO_DISCOGRAFICO");
                String formato = rs.getString("FORMATO");
                String edicion = rs.getString("EDICION");
                String nombrePista = rs.getString("NOMBRE_PISTA");
                String genero = rs.getString("GENERO");
                String urlPortada = rs.getString("URL_ICONO");
                String urlCancion = rs.getString("URL_PISTA");

                Cancion cancionAdd = new Cancion(0, formato, edicion, genero, selloDiscografico, nombreArtista, nombrePista, "Generos default", urlPortada, 2000, 0, urlCancion);
                listaCanciones.add(cancionAdd);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al conectar la BD: " + e);
        }
        return listaCanciones;
    }


}

package DAO;

import bd.Conexion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.ProcessBuilder.Redirect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Album;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author cybergato
 */
public class AlbumDAO {

    public List<Album> getAlbum1() {

        List<Album> lista = new ArrayList<>();

        try {

            Connection conn = Conexion.getConnection();

            String query = "SELECT ID_ALBUM, NOMBRE_ALBUM, FECHA_LANZAMIENTO, ARTISTA, URL_ICONO,precio,generos FROM ALBUMES";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String generos = rs.getString("generos");
                String idAlbum = rs.getString("ID_ALBUM");
                String nombre = rs.getString("NOMBRE_ALBUM");
                int anio = Integer.parseInt(rs.getString("FECHA_LANZAMIENTO"));
                String artistas = rs.getString("ARTISTA");
                String urlPortada = rs.getString("URL_ICONO");
                float precio = rs.getInt("precio");

                Album albumAdd = new Album(idAlbum,artistas,"","",null,nombre,generos,urlPortada,anio,precio);
                lista.add(albumAdd);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al conectar la BD: " + e);
        }

        return lista;

    }

}

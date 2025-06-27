package DAO;

import bd.Conexion;
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

    public List<Album> getAlbum() {

        List<Album> lista = new ArrayList<>();

        try {

            Connection conn = Conexion.getConnection();

            String query = "SELECT NOMBRE_ALBUM, FECHA_LANZAMIENTO, ARTISTA, URL_ICONO FROM ALBUMES";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String nombre = rs.getString("NOMBRE_ALBUM");
                int anio = Integer.parseInt(rs.getString("FECHA_LANZAMIENTO"));
                String artistas = rs.getString("ARTISTA");
                String urlPortada = rs.getString("URL_ICONO");

                Album albumAdd = new Album(nombre, "Generos default", urlPortada, anio, 0, artistas);
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

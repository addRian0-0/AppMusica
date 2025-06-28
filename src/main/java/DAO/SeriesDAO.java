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
import model.Serie;

/**
 *
 * @author PC
 */
public class SeriesDAO {

    public List<Serie> getSeries() {
        List<Serie> listaSeries = new ArrayList<>();

        try {
            FileReader reader = new FileReader("data/series.json");

            Gson gson = new Gson();
            java.lang.reflect.Type serieListType = new TypeToken<List<Serie>>() {
            }.getType();
            listaSeries = gson.fromJson(reader, serieListType);

            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo JSON de series: " + e.getMessage());
        }

        return listaSeries;
    }

}

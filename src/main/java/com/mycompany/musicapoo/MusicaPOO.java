/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.musicapoo;

import interfaces.Login;

/**
 *
 * @author JheromScript
 * @author cybergato
 */
public class MusicaPOO {

    public static void main(String[] args) {
        System.out.println("Aplicacion en ejecucion...");
        Login inicioScreen = new Login();
        inicioScreen.setVisible(true);
        inicioScreen.setLocationRelativeTo(null);
    }
}

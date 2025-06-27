package Reproducir;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.net.URL;
import javazoom.jl.player.Player;

public class Reproducir {
    private static Player player;

    public static void Reproducir(String urlStr) {
        try {
            if (player != null) {
                player.close();
            }
            URL url = new URL(urlStr);
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            player = new Player(bis);
            new Thread(() -> {
                try {
                    player.play();
                } catch (Exception e) {
                    System.err.println("Error al reproducir: " + e.getMessage());
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

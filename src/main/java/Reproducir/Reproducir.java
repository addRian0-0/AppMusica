package Reproducir;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.net.URL;
import javazoom.jl.player.Player;

public class Reproducir {
    private static Player player;
    private static javax.swing.Timer autoStopTimer;

    public static void Reproducir(String urlStr) {
        try {
            if (player != null) {
                player.close();
            }
            if (autoStopTimer != null) {
                autoStopTimer.stop();
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

            //timer para detener la cancion en 1 min
            autoStopTimer = new javax.swing.Timer(60000, evt -> {
                pausar();
                autoStopTimer.stop();
            });
            autoStopTimer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void pausar() {
        if (player != null) {
            player.close();
        }
    }

}

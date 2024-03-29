package ru.shishkin.maxim.versus;

import java.io.IOException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ThreadWithMusic extends Thread {
    public ThreadWithMusic() {
        start();
    }

    public void run() {
        while (true) {
            try {
                InputStream music = getClass().getClassLoader().getResourceAsStream("music.mp3");
                Player player = new Player(music);
                player.play();
                player.close();
                music.close();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

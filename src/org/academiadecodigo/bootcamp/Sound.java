package org.academiadecodigo.bootcamp;

import javax.sound.sampled.*;
import java.net.URL;

public class Sound {

    private AudioInputStream audioInputStream;
    private Clip clip;

    public void playSound(String path) {

        try {
            URL soundClip = getClass().getResource(path);
            audioInputStream = AudioSystem.getAudioInputStream(soundClip);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("oops");
        }
    }

    public void stopMusic() {
        clip.stop();
        clip.close();
    }

    public Clip getClip() {
        return clip;
    }
}
package com.company.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    public static synchronized void playLaughter() {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        Main.class.getResourceAsStream("start.wav"));
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.out.println("Файл start.wav не найден");
            }
        }).start();
    }

    public static synchronized void playWin() {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        Main.class.getResourceAsStream("winning.wav"));
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.out.println("Файл winning.wav не найден");
            }
        }).start();
    }

}
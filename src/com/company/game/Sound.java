package com.company.game;

import javazoom.jl.player.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;

public class Sound {

    public static void main(String[] args) {
        Sound.playLost();
    }

    public static synchronized void playLaughter() {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        Sound.class.getResourceAsStream("start.wav"));
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.out.println("Файл start.wav не найден");
            }
        }).start();
    }

    public static synchronized void playLost() {
        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream("E:/Work/TriTakProject/L00046/src/com/company/game/you-lost.mp3");
                Player playMP3 = new Player(fis);
                playMP3.play();
            } catch (Exception e) {
                System.out.println("Файл you-lost.mp3 не найден");
            }
        }).start();
    }

    public static synchronized void playExplosion() {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        Sound.class.getResourceAsStream("bomb-explosion.wav"));
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.out.println("Файл bomb-explosion.wav не найден");
            }
        }).start();
    }

    public static synchronized void playWin() {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        Sound.class.getResourceAsStream("winning.wav"));
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.out.println("Файл winning.wav не найден");
            }
        }).start();
    }
}

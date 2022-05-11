package com.company.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MyPanel extends JPanel {

    // Картинка фона
    private static Image background;

    // Картинка взрыва
    private static Image explosion;

    // Картинка неуспешного окончания игры
    private static Image game_over;

    // Картинка успешного окончания игры
    private static Image game_success;

    // Бомба
    private static Bomb[] bombs = new Bomb[5];

    // Очки
    private static int score;

    // Воспроизведение звука
    private static boolean isSound;

    public MyPanel() {
        try {
            background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));
            game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game-over.jpg"));
            game_success = ImageIO.read(GameWindow.class.getResourceAsStream("you-win.jpg"));

            for (int i = 0; i < bombs.length; i++) {
                bombs[i] = new Bomb(ImageIO.read(GameWindow.class.getResourceAsStream("bomb.jpg")));
            }
            explosion = ImageIO.read(GameWindow.class.getResourceAsStream("explosion.png"));
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Случилось исключение. Файл картинки не найден или поврежден");
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                //System.out.println("x: " + x + " y: " + y);

                for (int i = 0; i < bombs.length; i++) {
                    boolean is_drop = x >= bombs[i].getBomb_left() && x <= bombs[i].getBomb_right() && y >= bombs[i].getBomb_top() && y <= bombs[i].getBomb_bottom();
                    if (is_drop){
                        bombs[i].setExplosion(true);
                        Sound.playExplosion();
                        score++;
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(background, 0, 0, null);
        for (int i = 0; i < bombs.length; i++) {
            if (score >= 50){
                g.drawImage(game_success, 0, 0, null);
                if (!isSound) {
                    Sound.playWin();
                    isSound = true;
                }
                break;
            } else if (bombs[i].getBomb_top() > 768) {
                g.drawImage(game_over, 0, 0, null);
                if (!isSound) {
                    Sound.playLost();
                    isSound = true;
                }
                break;
            } else {
                bombs[i].setBomb_top(bombs[i].getBomb_top() + 5);
                bombs[i].setBomb_bottom(bombs[i].getBomb_top() + bombs[i].getBomb().getHeight(null));
                g.drawImage(bombs[i].getBomb(), bombs[i].getBomb_left(), bombs[i].getBomb_top(), null);
                if (bombs[i].isExplosion()) {
                    g.drawImage(explosion, bombs[i].getBomb_left(), bombs[i].getBomb_top(), null);
                }
                if (bombs[i].isExplosion()) {
                    bombs[i] = new Bomb(bombs[i].getBomb());
                }
            }
        }

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
}

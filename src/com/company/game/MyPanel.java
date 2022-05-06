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

    // Картинка фона
    private static Image explosion;
    private static boolean isExplosion;

    // Картинка неуспешного окончания игры
    private static Image game_over;

    // Картинка успешного окончания игры
    private static Image game_success;

    // Бомба
    private static Image bomb;
    private static int bomb_left = 200;
    private static int bomb_top = 0;

    // Очки
    private static int score;

    public MyPanel() {
        try {
            background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));
            game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game-over.jpg"));
            game_success = ImageIO.read(GameWindow.class.getResourceAsStream("you-win.jpg"));
            bomb = ImageIO.read(GameWindow.class.getResourceAsStream("bomb.jpg"));
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
                float drop_right = bomb_left + bomb.getWidth(null);
                float drop_bottom = bomb_top + bomb.getHeight(null);
                boolean is_drop = x >= bomb_left && x <= drop_right && y >= bomb_top && y <= drop_bottom;
                if (is_drop){
                    isExplosion = true;
                }
                score++;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        if (score >= 5){
            g.drawImage(game_success, 0, 0, null);
        } else if (bomb_top > 768) {
            g.drawImage(game_over, 0, 0, null);
        } else {
            bomb_top += 5; // drop_top = drop_top + 5;
            g.drawImage(background, 0, 0, null);
            g.drawImage(bomb, bomb_left, bomb_top, null);
            if (isExplosion) {
                g.drawImage(explosion, bomb_left, bomb_top, null);
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();

            if (isExplosion) {
                isExplosion = false;
                bomb_top = -100;
                bomb_left = (int) (Math.random() * (getWidth() - bomb.getWidth(null)));
            }
        }
    }
}

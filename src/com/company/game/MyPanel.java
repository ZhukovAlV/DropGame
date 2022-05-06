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

    // Картинка окончания игры
    private static Image game_over;

    // Капля
    private static Image bomb;
    private static int drop_left = 200;
    private static int drop_top = 0;


    public MyPanel() {
        try {
            background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));
            game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game-over.jpg"));
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
                float drop_right = drop_left + bomb.getWidth(null);
                float drop_bottom = drop_top + bomb.getHeight(null);
                boolean is_drop = x >= drop_left && x <= drop_right && y >= drop_top && y <= drop_bottom;
                if (is_drop){
                    isExplosion = true;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        drop_top += 5; // drop_top = drop_top + 5;
        g.drawImage(background, 0, 0, null);
        g.drawImage(bomb, drop_left, drop_top, null);
        if (isExplosion) {
            g.drawImage(explosion, drop_left, drop_top, null);
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();

        if (isExplosion) {
            isExplosion = false;
            drop_top = -100;
            drop_left = (int) (Math.random() * (getWidth() - bomb.getWidth(null)));
        }
    }
}

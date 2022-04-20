package com.company.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanel extends JPanel {

    // Картинка фона
    private static Image background;

    // Картинка окончания игры
    private static Image game_over;

    // Капля
    private static Image drop;
    private static int drop_left = 200;
    private static int drop_top = 0;
    private static float drop_v = 10;

    // Очки
    private static int score;

    public MyPanel() {
        try {
            background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
            game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
            drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        } catch (Exception e) {
            System.out.println(e);
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float drop_right = drop_left + drop.getWidth(null);
                float drop_bottom = drop_top + drop.getHeight(null);
                boolean is_drop = x >= drop_left && x <= drop_right && y >= drop_top && y <= drop_bottom;
                if(is_drop) {
                    drop_top = -100;
                    drop_left = (int) (Math.random() * (getWidth() - drop.getWidth(null)));
                   // drop_v = drop_v + 20;
                    score++;
                  //  game_window.setTitle("Score: " + score);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        drop_top += drop_v;
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, drop_left, drop_top, null);
        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

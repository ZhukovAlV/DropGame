package com.company.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

public class MyPanel extends JPanel {

    // Картинка фона
    private static Image background;

    // Картинка неуспешного окончания игры
    private static Image game_over;

    // Картинка успешного окончания игры
    private static Image victory;

    // Бомба
    private static Image bomb;
    private static int bomb_top = 0;
    private static int bomb_left = 200;

    // Бомба
    private static Image explosion;

    public MyPanel() {
        try {
            //InputStream path = GameWindow.class.getResourceAsStream("background.jpg1");
            //background = ImageIO.read(path);
            background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));

            game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.jpg"));
            bomb = ImageIO.read(GameWindow.class.getResourceAsStream("bomb.jpg"));
            explosion = ImageIO.read(GameWindow.class.getResourceAsStream("explosion.png"));
            victory = ImageIO.read(GameWindow.class.getResourceAsStream("victory.jpg"));
        } catch (IOException e) {
            System.out.println("Случилось исключение. Файл картинки не найден или поврежден");
        } catch (IllegalArgumentException ex) {
            System.out.println("Случилось исключение. Не удалось открыть поток");
        }


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float bomb_right = bomb_left + bomb.getWidth(null);
                float bomb_bottom = bomb_top + bomb.getHeight(null);

                //Нажали ли мы по нашей бомбе
                boolean is_bomb = x >= bomb_left && x <= bomb_right && y >= bomb_top && y <= bomb_bottom;

                if(is_bomb) {
                    bomb_top = -100;
                    bomb_left = (int) (Math.random() * (getWidth() - bomb.getWidth(null)));
                }
            }
        });


    }

    @Override
    protected void paintComponent(Graphics g){
        bomb_top += 5; // drop_top = drop_top + 5;
        g.drawImage(background, 0, 0, null);
        g.drawImage(bomb, bomb_left, bomb_top, null);
        repaint();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

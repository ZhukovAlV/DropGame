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
    private static boolean isExplosion;

    // Очки
    private static int score;

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
                    isExplosion = true;
                    score = score + 1; // score += 1;
                }

                if (score == 1) {
                    Sound.playWin();
                }
            }
        });


    }

    @Override
    protected void paintComponent(Graphics g){

        if (score == 1) {
            g.drawImage(victory, 0, 0, null);
        } else {
            // Увеличиваем значение y бомбы
            bomb_top += 5; // drop_top = drop_top + 5;
            // Фон
            g.drawImage(background, 0, 0, null);
            // Бомба
            g.drawImage(bomb, bomb_left, bomb_top, null);
            // Взрыв бомбы
            if (isExplosion) {
                // Нарисовали картинку взрыва
                g.drawImage(explosion, bomb_left, bomb_top, null);
                // Пауза
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Скрываем бомбу
                bomb_top = -100;
                bomb_left = (int) (Math.random() * (getWidth() - bomb.getWidth(null)));
                // Выставлем взрыв на false
                isExplosion = false;
            }
        }



        repaint();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.company.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyPanel extends JPanel {

    // Картинка фона
    private static Image background;

    // Картинка окончания игры
    private static Image game_over;

    // Капля
    private static Image drop;
    private static int drop_top = 0;

    public MyPanel() {
        try {
            background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
            game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
            drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        } catch (IOException e) {
            System.out.println("Случилось исключение. Файл картинки не найден или поврежден");
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        drop_top += 5; // drop_top = drop_top + 5;
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, 0, drop_top, null);
        repaint();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

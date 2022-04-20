package com.company.game;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(JPanel panel) {
        setSize(1024, 768);
        setTitle("Game");
        add(panel);

        setVisible(true);
    }

}

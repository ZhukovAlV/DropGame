package com.company.game;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Сперва создается панель
        MyPanel panel = new MyPanel();
        // Затем окно
        new GameWindow(panel);
    }
}

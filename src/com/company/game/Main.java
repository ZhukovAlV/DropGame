package com.company.game;

public class Main {

    public static void main(String[] args) {
        // Сперва создается панель
        MyPanel panel = new MyPanel();
        // Затем окно
        new GameWindow(panel);
        // Запускаем фоновую музыку
        Sound.playLaughter();
    }
}

package com.company.game;

import javax.swing.*;

public class Test {

    public static void main(String[] args) {

        // Создаем объект
        JFrame frame = new JFrame();  // var frame = new JFrame();
        // Размеры окна
        frame.setSize(1024, 768);
        // Задаем заголовок
        frame.setTitle("Game");

        // Это наш контейнер для компонентов
        JPanel panel = new JPanel();

        JButton button = new JButton("Кнопка");
        panel.add(button);

       // JLabel label = new JLabel();
      //  label.setText("Отметка");

        JLabel label = new JLabel("Отметка");



        panel.add(label);

        // Добавляем в окно панель со всеми компонентами
        frame.add(panel);
        // Видимость
        frame.setVisible(true);

    }
}

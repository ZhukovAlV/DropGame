package com.company.hero;

public class Hero {
    static String name;
    int age;

    public Hero(String name, int age) {
        //System.out.println("Здесь отрабатывает конструктор для 2 аргументов: Имени и возраста");
        this.name = name;
        this.age = age;
    }

    public Hero(String peter_parker) {
        //System.out.println("Здесь отрабатывает конструктор для 1 аргумента: Имени");
        name = peter_parker; //  this.name = peter_parker;
    }

    public Hero() {
    }
}

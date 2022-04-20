package com.company.zoo;

public class Carnivores extends Animal {

    @Override
    public void getName() {
        System.out.println("It's a carnivores");
    }

    @Override
    public void eat() {
        System.out.println("This animal eats animals only");
    }

    public void countAnimal() {
        System.out.println("Predators eat 2 gophers a day");
    }
}

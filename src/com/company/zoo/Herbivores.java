package com.company.zoo;

public class Herbivores extends Animal {

    @Override
    public void getName() {
        System.out.println("It's a herbivores");
    }

    @Override
    public void eat() {
        System.out.println("This animal eats plants only");
    }
}

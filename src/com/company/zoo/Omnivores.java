package com.company.zoo;

public class Omnivores extends Animal {

    @Override
    public void getName() {
        System.out.println("It's a omnivores");
    }

    @Override
    public void eat() {
        System.out.println("This animal eats plants and animals");
    }
}

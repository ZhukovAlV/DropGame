package com.company.zoo;

public class Main {

    public static void main(String[] args) {
/*        Animal animal = new Animal();

        animal.getName();
        animal.eat();*/
/*

/*

        Carnivores entity = new Carnivores();
        entity.getName();
        entity.eat();
        entity.countAnimal();

*/

        Carnivores carnivores = new Carnivores();
        getType(carnivores);

        Herbivores herbivores = new Herbivores();
        getType(herbivores);

    }

    public static void getType(Animal animal) {
        animal.getName();
        animal.eat();
    }

}

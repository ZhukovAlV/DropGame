package com.company.comics;

public class Main {

    public static void main(String[] args) {
        var batman = new Hero();
        batman.name = "Bruce Wayne";
        batman.age = 40;
        batman.power = 50;
        batman.agility = 70;
        batman.gender = 'M';
        batman.superpower = "Technologies";
        batman.savedPeople = 90;

        batman.weapon = new Batrang();
        batman.weapon.name = "Batrang";
        System.out.println(batman.weapon.attack());

        var joker = new Villain();
        joker.name = "Joker ";
        joker.age = 50;
        joker.power = 60;
        joker.agility = 70;
        joker.gender = 'M';
        joker.superpower = "Madness";
        joker.statusDanger = 90;

      //  joker.weapon = new PhysicalWeapon();
     //   joker.weapon.name = "Сane";
       // System.out.println(joker.weapon.attack());

        joker.weapon = new Knife();
        joker.weapon.name = "Knife";
        System.out.println(joker.weapon.attack());
    }
}

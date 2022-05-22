package com.company.getterandsetter;

public class Main {

    public static void main(String[] args) {

        // Создаем человек счетом
        Person dima = new Person("Dima", new Money(1000));

     //   System.out.println(dima.money.getCount());

        dima.getMoney().getMoney(200);

       // Это хакер постарался
       // dima.money.count = 1000;

     //   System.out.println(dima.money.getCount());


        Person alex = new Person("Alexey", new Money(1200));
        alex.name = "Alexey";


        System.out.println("Алексей: " + alex.getMoney().getCount());
        System.out.println("Дима: " + dima.getMoney().getCount());

        // Хакер привязал Диме счет Алексей
       // dima.getMoney() = alex.getMoney();

        System.out.println("Алексей: " + alex.getMoney().getCount());
        System.out.println("Дима: " + dima.getMoney().getCount());


        dima.getMoney().getMoney(200);

        System.out.println("Алексей: " + alex.getMoney().getCount());
        System.out.println("Дима: " + dima.getMoney().getCount());
    }
}

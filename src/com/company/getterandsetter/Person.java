package com.company.getterandsetter;

public class Person {

    public String name;
    private Money money;

    public Person(String name, Money money) {
        this.name = name;
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }
}

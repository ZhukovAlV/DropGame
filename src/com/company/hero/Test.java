package com.company.hero;

public class Test {
    public static void main(String[] args) {

/*        Hero spiderMan = new Hero();
        spiderMan.name = "Peter Parker";
        spiderMan.age = 23;

        System.out.println(spiderMan.name);

        Hero batman = new Hero();
        batman.name = "Bruce Wayne";
        batman.age = 40;

        System.out.println(batman.name);*/

        Hero spiderMan = new Hero("Peter Parker", 23);


        Hero batman = new Hero("Bruce Wayne",40);


        System.out.println(spiderMan.name);
        System.out.println(spiderMan.age);

        System.out.println(batman.name);
        System.out.println(batman.age);

    }


}

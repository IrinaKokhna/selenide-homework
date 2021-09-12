package guru.qa.tests;

import guru.qa.docs.Cat;

public class CatTest {

    public static void main(String[] args) {
        Cat keks = new Cat("Кекс", 7, "Черно-белый");
        Cat gretta = new Cat("Гретта", 11,"Рыжий");
        keks.jump();
        System.out.println(keks.getName());
        keks.setName("NeKeks");
        System.out.println(keks.getName());
        gretta.meow();
        gretta.jump();
        System.out.println("Кот по имени " + keks.getName() + " имеет "+ keks.getColor() + " окрас "+ "и его возраст - "
                + keks.getAge());
        System.out.println("Кот по имени " + gretta.getName() + " имеет "+ gretta.getColor()+ " окрас "+"и, его возраст - "
                + gretta.getAge());
    }

}

package guru.qa.docs;

import lombok.Data;

@Data
public class Cat {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void jump() {
        System.out.println("Тыгыдык");
    }
    public void meow() {
        System.out.println("Мяу!");
    }
}

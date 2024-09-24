package ru.dorogov.patterns;

public class Cat implements Mayable {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void may() {
        System.out.println(name + ": may");
    }
}

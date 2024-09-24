package ru.dorogov.birds;

//3.2.3
// Базовый класс для всех птиц
public abstract class Bird {
    public void sing() {
        System.out.println(getSong());
    }

    public abstract String getSong();
}

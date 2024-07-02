package ru.dorogov.birds;

//3.2.3
// Базовый класс для всех птиц
abstract class Bird {
    public final void sing() {
        System.out.println(getSong());
    }

    public abstract String getSong();
}

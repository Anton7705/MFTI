package ru.dorogov.patterns;

import ru.dorogov.birds.Bird;

public class SingableCat extends Bird {
    Cat c1;

    public SingableCat(Cat c1) {
        this.c1 = c1;
    }

    @Override
    public void sing () {
        c1.may();
    }

    @Override
    public String getSong() {
        return "";
    }
}

package ru.dorogov.patterns;

public class MayCounter implements Mayable{
    int counter;
    Cat c1;

    public MayCounter(Cat c1) {
        this.c1 = c1;
    }

    @Override
    public void may () {
        counter++;
        c1.may();
    }
}

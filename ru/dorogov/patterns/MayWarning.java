package ru.dorogov.patterns;

public class MayWarning implements Mayable{
    Mayable c1;

    public MayWarning(Mayable c1) {
        this.c1 = c1;
    }

    @Override
    public void may () {
        System.out.print("Warning! " );
        c1.may();
    }
}

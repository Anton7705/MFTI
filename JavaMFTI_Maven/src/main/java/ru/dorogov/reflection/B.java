package ru.dorogov.reflection;

import org.springframework.stereotype.Component;

@Component


public class B {
    @Default Integer x;
    String s;

    @Override
    public String toString() {
        return "B{" +
                "x=" + x +
                ", s='" + s + '\'' +
                '}';
    }
}
package ru.dorogov.reflection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Default
@Qualifier("A")
public class A {
    Integer x;
    String s;

    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                ", s='" + s + '\'' +
                '}';
    }
}


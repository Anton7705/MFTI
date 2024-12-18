package ru.dorogov.reflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Qualifier("B")
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
package ru.dorogov.reflection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.dorogov.reflection");
        A a = (A) context.getBean("a");
        System.out.println(a);
        B b = (B) context.getBean(B.class);
        System.out.println(b);

    }

}


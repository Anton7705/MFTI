package ru.dorogov.main;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Predicate;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.dorogov.mySpring");
        System.out.println(new Date());
        Thread.sleep(1000);
        String h1 = (String) ctx.getBean("hi");
        System.out.println(h1);

        int i1 = (int) ctx.getBean("random");
        int i2 = (int) ctx.getBean("random");
        int i3 = (int) ctx.getBean("random");
        int i4 = (int) ctx.getBean("random");
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);

        Date date = (Date) ctx.getBean("date");
        System.out.println(date);
        Thread.sleep(1000);
        Date date1 = (Date) ctx.getBean("date");
        System.out.println(date1);

        Predicate<Integer> p = (Predicate<Integer>) ctx.getBean("rule");
        System.out.println(p.test(4));

        int I1 = ctx.getBean("max", int.class);
        System.out.println(I1);

        int I2 = ctx.getBean("min", int.class);
        System.out.println(I2);

    }
}



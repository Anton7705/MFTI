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
        A a = context.getBean(A.class);
        System.out.println(a);
        B b = context.getBean(B.class);
        System.out.println(b);

    }
}
//
//    @Bean
//    public CachePostProcessor cachePostProcessor() {
//        return new CachePostProcessor();
//    }
//
//    @Bean
//    public MyBean myBean() {
//        return new MyBean();
//    }
//}
//
//@Component
//class MyBean {
//
//    private int value = 100;
//
//    @Cache
//    public int getValue() {
//        return value;
//    }
//
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//}
//
//

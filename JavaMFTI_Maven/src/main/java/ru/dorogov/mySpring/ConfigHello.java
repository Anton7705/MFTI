package ru.dorogov.mySpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigHello {

    @Bean
    String hi() {
        return "Hello world";
    }

    @Bean("min")
    int i1() {
        return -1;
    }

    @Bean("max")
    int i2() {
        return 3;
    }
}

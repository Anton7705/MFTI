package ru.dorogov.mySpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigHello {

    @Bean
    String hi() {
        return "Hello world";
    }
}

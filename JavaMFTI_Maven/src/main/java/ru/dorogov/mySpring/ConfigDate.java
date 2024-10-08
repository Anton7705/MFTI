package ru.dorogov.mySpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
public class ConfigDate {

    @Bean
    @Lazy
    Date date() {
        Date date = new Date();
        return date;
    }
}

package ru.dorogov.mySpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;



@Configuration
public class ConfigRule {
    @Bean
    Predicate<Integer> rule() {
        return integer -> 2 <= integer && integer <= 5;
    }

}

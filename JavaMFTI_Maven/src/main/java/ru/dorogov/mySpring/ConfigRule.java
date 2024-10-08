package ru.dorogov.mySpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;



@Configuration
public class ConfigRule {
    @Bean
    Predicate<Integer> rule() {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (2 <= integer && integer <= 5) {
                    return true;
                } else return false;
            }
        };
        return predicate;
    }

}

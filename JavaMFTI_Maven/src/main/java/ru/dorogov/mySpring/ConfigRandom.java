package ru.dorogov.mySpring;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.*;

@Configuration
public class ConfigRandom {

    private List<Integer> integerSet = new ArrayList<>();
    void refresh(int min, int max){
        for (int i = min; i < max; i++) {
            integerSet.add(i);
        }
    }

    @Bean
    @Scope("prototype")
    int random(@Qualifier("min") Integer min, @Qualifier("max") Integer max) {
        Random random = new Random();
        if (integerSet.size() == 0) {
            refresh(min, max);
        }
        int x = random.nextInt(0, integerSet.size());
        int res = integerSet.get(x);
        integerSet.remove(x);
        return res;
    }

}

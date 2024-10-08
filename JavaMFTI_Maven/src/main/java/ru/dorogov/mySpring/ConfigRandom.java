package ru.dorogov.mySpring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.function.Predicate;

@Configuration
public class ConfigRandom {
    private int min;
    private int max;
    private HashSet<Integer> integerSet;

    @Autowired
    @Qualifier("min")
    void setMin(int min) {
        this.min = min;
    }

    @Autowired
    @Qualifier("max")
    void setMax(int max) {
        this.max = max;
    }

    @Autowired
    @Qualifier("RandomSet")
    void setIntegerSet(HashSet<Integer> hashSet) {
        this.integerSet = hashSet;
    }


    @Bean
    @Scope("prototype")
    int random() {
        Random random = new Random();
        int x = random.nextInt(min, max);
        if (integerSet.size() == 0) {
            return x;
        }
        while (!integerSet.contains(x)) {
            x = random.nextInt(min, max);
        }
        integerSet.remove(x);
        return x;
    }

    @Bean("min")
    int i1() {
        return -1;
    }

    @Bean("max")
    int i2() {
        return 3;
    }

    @Bean("RandomSet")
    HashSet<Integer> hashSetRandom() {
        HashSet<Integer> integerSet = new HashSet<>();
        for (int i = min; i < max; i++) {
            integerSet.add(i);
        }
        return integerSet;
    }
}

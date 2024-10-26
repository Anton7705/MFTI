package ru.dorogov.reflection;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumber {
    private final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(101);
    }
}

package ru.dorogov.birds;

import java.util.Random;

//3.2.3
public class Cuckoo extends Bird {

    @Override
    public String getSong() {
        String song = "";
        int rand = new Random().nextInt(1, 11);
        for (int i = 0; i < rand; i++) {
            song += "ку-ку ";
        }
        return song;
    }
}
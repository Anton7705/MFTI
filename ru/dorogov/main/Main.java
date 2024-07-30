package ru.dorogov.main;

import ru.dorogov.сhapter5.*;
import ru.dorogov.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hot h1 = Hot.HOT;
        int i = h1.grade;
        Hot h2 = Hot.MEDIUM;
        Hot h3 = Hot.HOT;
        Hot h4 = Hot.values()[0];
        System.out.println(h1 == h4);
        System.out.println(i);
    }
}

enum Hot {LOW(0), MEDIUM(10), HOT(20);
    int grade;

    Hot(int grade) {
        this.grade = grade;
    }
}

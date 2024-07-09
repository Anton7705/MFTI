package ru.dorogov.main;

import ru.dorogov.birds.Bird;
import ru.dorogov.birds.Sparrow;
import ru.dorogov.geometry.CircuitPolyLine;
import ru.dorogov.geometry.Line;
import ru.dorogov.geometry.Point;
import ru.dorogov.geometry.PolyLine;
import ru.dorogov.mathematics.Fraction;
import ru.dorogov.transport.City;
import ru.dorogov.transport.CityModified;
import ru.dorogov.transport.Road;

public class Main {
    public static void main(String[] args) {
        Point l1 = new Point(1,1);
        Point l2 = new Point(1,1);
        Point l3 = l2.clone();
        l3.setX(4);
        System.out.println(l1.equals(l3));
    }
}


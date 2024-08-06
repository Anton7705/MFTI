package ru.dorogov.сhapter5;

import ru.dorogov.geometry.Line;
import ru.dorogov.geometry.Point;
import ru.dorogov.geometry.Point3D;

import java.util.ArrayList;
import java.util.Random;

public class Methods {

    //    5.2.1
    public static <T extends Point> void move(Line<T> line) {
        line.getP1().setX(line.getP1().getX() + 10);
    }


    //    5.2.2
    public static double max(Box<? extends Number>... boxes) {
        double def = Double.MIN_VALUE;
        for (int i = 0; i < boxes.length; i++) {
            Number n = boxes[i].get();
            if (n == null) {
                throw new IllegalArgumentException("The box must be filled");
            }
            double current = n.doubleValue();
            if (current > def) {
                def = current;
            }
        }
        return def;
    }

    // 5.2.3

    public static Box<? super Point3D> pointInBox(Box<? super Point3D> box) {
        box.set(new Point3D(new Random().nextInt(-1000, 1000), new Random().nextInt(-1000, 1000), new Random().nextInt(-1000, 1000)));
        return box;
    }

    // 5.2.4
    public static ArrayList<? super Integer> fill(ArrayList<? super Integer> arrays) {
        arrays.clear();
        for (int i = 1; i < 101; i++) {
            arrays.add(i);
        }
        return arrays;
    }
}
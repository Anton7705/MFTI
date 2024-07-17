package ru.dorogov.Charpet5;

import ru.dorogov.geometry.Line;
import ru.dorogov.geometry.Point;
import ru.dorogov.geometry.Point3D;

import java.util.ArrayList;
import java.util.Random;

public class Methods {

    //    5.2.1
    public static <T extends Point> Line<T> move(Line line) {
        if (line.getP1() instanceof Point3D point3D) {
            if (line.getP1().getX() >= 0) {
                line.setP1(new Point3D(point3D.getX() + 10, point3D.getY(), point3D.getZ()));
                return line;
            }
            if (line.getP1().getX() < 0) {
                line.setP1(new Point3D(point3D.getX() - 10, point3D.getY(), point3D.getZ()));
                return line;
            } else if (line.getP1() instanceof Point point) {
                if (line.getP1().getX() >= 0) {
                    line.setP1(new Point(point.getX() + 10, point.getY()));
                    return line;
                }
                if (line.getP1().getX() < 0) {
                    line.setP1(new Point(point.getX() - 10, point.getY()));
                    return line;
                }
            }
        }
        return line;
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

    public static Box<Point3D> pointInBox(Box<? super Point3D> box) {
        box.set(new Point3D(new Random().nextInt(-1000, 1000), new Random().nextInt(-1000, 1000), new Random().nextInt(-1000, 1000)));
        return (Box<Point3D>) box;
    }

    // 5.2.4
    public static ArrayList<Integer> fill (ArrayList<? super Integer> arrays) {
        for (int i = 1; i < 101; i++) {
            arrays.add(i);
        }
        return (ArrayList<Integer>) arrays;
    }
}
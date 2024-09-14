package ru.dorogov.streamApi;

import ru.dorogov.geometry.Point;
import ru.dorogov.geometry.PolyLine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Задание 1
public class Stream1 {
    public static void main(String[] args) throws FileNotFoundException {

        class PointFun implements Function<Point, Point> {
            @Override
            public Point apply(Point point) {
                if (point.getY() < 0) {
                    point.setY(-point.getY());
                }
                return point;
            }
        }

        PolyLine p1 = Stream.of(new Point(-5, -6), new Point(1, -2), new Point(3, 22), new Point(10, 9), new Point(3, -22))
                .sorted((x, y) -> x.getX() - y.getX())
                .map(new PointFun())
                .distinct()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        points -> new PolyLine(points)
                ));

        System.out.println(p1);

        // Задание 2

        Scanner sc = new Scanner(new File("/Users/antondorogov/Desktop/students.txt"));

        Map<Integer, List<String>> str1 = Stream.generate(() -> sc.next())
                .takeWhile(x -> sc.hasNext())
                .map(s -> s.substring(0, 1).toUpperCase().trim()
                        + s.substring(1).toLowerCase().trim())
                .filter(line -> line.contains(":"))
                .map(line -> line.split(":"))
                .collect(Collectors.groupingBy(
                        x -> Integer.parseInt(x[1]),
                        Collectors.mapping(x -> x[0],
                                Collectors.toList())
                ));


        System.out.println(str1);
    }
}






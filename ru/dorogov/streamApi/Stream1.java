package ru.dorogov.streamApi;

import ru.dorogov.geometry.Point;
import ru.dorogov.geometry.PolyLine;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

// Задание 1
public class Stream1 {
    public static void main(String[] args) {

        class PointFun implements Function<Point, Point> {
            @Override
            public Point apply(Point point) {
                if (point.getY() < 0) {
                    point.setY(-point.getY());
                }
                return point;
            }
        }

        PolyLine p1 = new PolyLine().setList(Stream.of(new Point(-5, -6), new Point(1, -2), new Point(3, 22), new Point(10, 9), new Point(3, -22))
                .sorted((x, y) -> x.getX() - y.getX())
                .map(new PointFun())
                .distinct()
                .toList());
        System.out.println(p1);


        String text = "ВАСЯ:5\nПетя:3\nанЯ:5\nДима";

        // Задание 2


        Map<Integer, List<String>> groupedPeople = new HashMap<>();

        List<Integer> integerList = new ArrayList<>();

        class MyMap implements Function<String, Map<Integer, List<String>>> {
            @Override
            public Map<Integer, List<String>> apply(String s) {
                String s1 = s.substring(0, 1).toUpperCase().trim() + s.substring(1).toLowerCase().trim();
                String[] strings = s1.split(":");

                int num = Integer.parseInt(strings[1]);
                List lst= new ArrayList<>();
                if (integerList.contains(num)) {
                    groupedPeople.get(num).add(strings[0]);
                } else {
                    lst.add(strings[0]);
                groupedPeople.put(num, lst);
                }
                integerList.add(num);
                return groupedPeople;
            }
        }

        Arrays.stream(text.split("\n"))
                .filter(line -> line.contains(":"))
                .map(new MyMap()).toArray();

        System.out.println(groupedPeople);

    }
}






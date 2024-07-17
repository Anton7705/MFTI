package ru.dorogov.main;
import ru.dorogov.Charpet5.*;
import ru.dorogov.education.*;
import ru.dorogov.geometry.Line;
import ru.dorogov.geometry.Point3D;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.set(3);
        int i1 = box.get().intValue();
        System.out.println(i1);

        Storage<Integer> s = Storage.create(null);
        int i2 = s.get(0).intValue();
        System.out.println(i2);

        Storage<Integer> s1 = Storage.create(99);
        int i3 = s1.get(-1).intValue();
        System.out.println(i3);

        Storage<String> s2 = Storage.create(null);
        System.out.println(s2.get("default"));

        Storage<String> s3 = Storage.create("hello");
        System.out.println(s3.get("hello world"));

        Student stud1 = new Student("BOB", 5, 4, 5);
        Student Stud2 = new Student("POP", 4, 5, 4);
        System.out.println(stud1.compare(Stud2));

        Line<Point3D> l1 = Line.create(new Point3D(0, 1, 1), new Point3D(5, 5, 5));
        System.out.println(l1);
        Methods.move(l1);
        System.out.println(l1);

        Box<Integer> b1 = new Box<>();
        b1.set(55);
        Box<Double> b2 = new Box<>();
        b2.set(33.0);
        Box<Number> b3 = new Box<>();
        b3.set(900);
        Box<Float> b4 = new Box<>();
        b4.set(9000.90F);
        System.out.println(Methods.max(b1, b2, b3, b4));

        Box<Object> b5 = new Box<>();
        Methods.pointInBox(b5);
        System.out.println(b5.get());

        ArrayList<Number> arrayList = new ArrayList<>();
        Methods.fill(arrayList);
        System.out.println(arrayList);
    }
}


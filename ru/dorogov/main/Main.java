package ru.dorogov.main;

import ru.dorogov.education.Student;
import ru.dorogov.сhapter5.*;
import ru.dorogov.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Vasia");
        st1.addMarks(3);
        System.out.println(st1);

        st1.setName("Ann");
        st1.addMarks(5);
        st1.addMarks(5);
        System.out.println(st1);

        st1.undo();
        st1.undo();
        st1.undo();
        System.out.println(st1);
    }
}


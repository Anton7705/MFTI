package ru.dorogov.main;

import ru.dorogov.mathematics.Сalculations;
import ru.dorogov.geometry.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        //4.1.2
        Rectangle r1 = new Rectangle(new Point(1, 1), 5);
        Rectangle r2 = new Rectangle(new Point(3, 4), 5);
        System.out.println(Methods.summSquare(r1, r2));
        Line l1 = new Line(1, 2, 3, 4);
        PolyLine l2 = new PolyLine(new Point(1, 2), new Point(5, 5));
        System.out.println(Methods.summOfLines(l1, l2));
        //4.1.3
        BigInteger bigInteger = new BigInteger("12345678912345678912");
        System.out.println(Сalculations.sumNumbers(7, 11 / 3.0, 3.21, bigInteger));
        //4.1.4
        System.out.println(Сalculations.exponentiation(args[0], args[1]));
        //4.1.5
        java.awt.Point awtp1 = new java.awt.Point(10, 15);
        Point p2 = new Point(2, 9);
        System.out.println(awtp1);
        System.out.println(p2);
    }
}


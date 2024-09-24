package ru.dorogov.geometry;

//3.2.4
public class Triangle extends Figure {
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        super(p1);
        check(p2);
        check(p3);
        this.p2 = p2;
        this.p3 = p3;
    }

    public void check(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Точка должна быть определена");
        }
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        check(p2);
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        check(p3);
        this.p3 = p3;
    }

    private double lengthTwo(Point p1, Point p2) {
        double i1 = p1.getX() - p2.getX();
        double i2 = p1.getY() - p2.getY();
        double length = i1 * i1 + i2 * i2;
        return Math.sqrt(length);
    }

    private double halfOfPerimetr() {
        return (lengthTwo(getP1(), getP2()) + lengthTwo(getP2(), getP3()) + lengthTwo(getP3(), getP1())) / 2;
    }


    @Override
    public double findSquare() {
        double d1 = lengthTwo(getP1(), getP2());
        double d2 = lengthTwo(getP2(), getP3());
        double d3 = lengthTwo(getP3(), getP1());
        double res = Math.sqrt(halfOfPerimetr() * (halfOfPerimetr() - d1) * (halfOfPerimetr() - d2) * (halfOfPerimetr() - d3));
        if (res == 0) {
            throw new ArithmeticException("Этот треугольник вырожденный");
        }
        return res;
    }

    @Override
    public String toString() {
        return "Треугольник с координатами: " + getP1() + getP2() + getP3();
    }
}

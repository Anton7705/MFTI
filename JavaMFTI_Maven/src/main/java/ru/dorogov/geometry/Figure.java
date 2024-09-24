package ru.dorogov.geometry;

//3.2.4
public abstract class Figure {
    public static final double PI = 3.14;

    private Point p1;

    public Figure(Point p1) {
        setP1(p1);
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        if (p1 == null) {
            throw new IllegalArgumentException("Точка должна быть определена");
        }
        this.p1 = p1;
    }

    public abstract double findSquare();
}

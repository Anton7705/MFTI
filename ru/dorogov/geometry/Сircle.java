package ru.dorogov.geometry;

//3.2.4
public class Сircle extends Figure {
    private int radius;

    public Сircle(Point p1, int radius) {
        super(p1);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус круга должен быть больше 0");
        }
        this.radius = radius;
    }

    @Override
    public double findSquare() {
        return PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Круг в точке " + getP1() + " со радиусом " + radius;
    }
}

package ru.dorogov.geometry;

//3.1.2
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int lengthTo(Point target) {
        int i1 = this.getX() - target.getX();
        int i2 = this.getY() - target.getY();
        int length = i1 * i1 + i2 * i2;
        return (int) Math.sqrt(length);
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

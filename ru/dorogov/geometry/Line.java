package ru.dorogov.geometry;

import java.util.Objects;

// 1.6.6
public class Line implements Lengthable, Cloneable {
    Point p1;
    Point p2;

    public Line(Point p1, Point p2) {
        setP1(p1);
        setP2(p2);
    }

    public Line(int x1, int x2, int y1, int y2) {
        this.p1 = new Point(x1, x2);
        this.p2 = new Point(y1, y2);
    }

    @Override
    public String toString() {
        return "Линия от " + p1.toString() + " до " + p2.toString();
    }

    public int length() {
        int i1 = p2.getX() - p1.getX();
        int i2 = p2.getY() - p1.getY();
        int length = i1 * i1 + i2 * i2;
        return (int) Math.sqrt(length);
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        if (p1 == null) throw new IllegalArgumentException("Линия не должна содержать null элементы");
        this.p1 = new Point(p1.getX(), p1.getY());
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        if (p2 == null) throw new IllegalArgumentException("Линия не должна содержать null элементы");
        this.p2 = new Point(p2.getX(), p2.getY());
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Line line)) return false;
        return Objects.equals(p1, line.p1) && Objects.equals(p2, line.p2);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(p1, p2);
    }

    @Override
    public Line clone() {
        try {
            Line line = (Line) super.clone();
            line.p1 = this.p1.clone();
            line.p2 = this.p2.clone();
            return line;
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException();
        }
    }
}

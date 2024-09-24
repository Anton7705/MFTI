package ru.dorogov.geometry;

import java.util.Objects;

// 1.6.6
public class Line<T extends Point> implements Lengthable, Cloneable {
    private T p1;
    private T p2;

    private Line(T p1, T p2) {
        setP1(p1);
        setP2(p2);
    }

    public static <K extends Point> Line<K> create(K point1, K point2) {
        return new Line<>(point1, point2);
    }

    public static <K extends Point> Line<K> create(int x1, int y1, int x2, int y2) {
        K p1 = (K) new Point(x1, y1);
        K p2 = (K) new Point(x2, y2);
        return new Line<>(p1, p2);
    }

    public static <K extends Point> Line<K> create(int x1, int y1, int x2, int y2, int z1, int z2) {
        K p1 = (K) new Point3D(x1, y1, z1);
        K p2 = (K) new Point3D(x2, y2, z2);
        return new Line<>(p1, p2);
    }

    @Override
    public String toString() {
        return "Линия от " + p1.toString() + " до " + p2.toString();
    }

    public int length() {
        return p1.lengthTo(p2);
    }

    public T getP1() {
        return p1;
    }

    public void setP1(T p1) {
        if (p1 == null) throw new IllegalArgumentException("Линия не должна содержать null элементы");
        this.p1 = (T) p1.clone();
    }

    public T getP2() {
        return p2;
    }

    public void setP2(T p2) {
        if (p2 == null) throw new IllegalArgumentException("Линия не должна содержать null элементы");
        this.p2 = (T) p2.clone();
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
    public Line<T> clone() {
        try {
            Line line = (Line) super.clone();
            line.p1 = this.p1.clone();
            line.p2 = this.p2.clone();
            return line;
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }

}

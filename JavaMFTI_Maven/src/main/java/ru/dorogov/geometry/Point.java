package ru.dorogov.geometry;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

//3.1.2
@Data
public class Point implements Cloneable {

     int x;

     int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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


    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }
}

package ru.dorogov.geometry;

import java.util.Objects;

public class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Point3D point3D)) return false;
        if (!super.equals(object)) return false;
        return z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    @Override
    public int lengthTo(Point target) {
        if (target instanceof Point3D point3D) {
            int i1 = this.getX() - point3D.getX();
            int i2 = this.getY() - point3D.getY();
            int i3 = this.getZ() - point3D.getZ();
            int length = i1 * i1 + i2 * i2 + i3 * i3;
            return (int) Math.sqrt(length);
        } else return super.lengthTo(target);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

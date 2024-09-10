package ru.dorogov.geometry;//3.1.2

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PolyLine implements Lengthable {
    List<Point> list = new ArrayList<>();

    public List<Point> getList() {
        return new ArrayList<>(list);
    }

    public PolyLine setList(List<Point> list) {
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == null || list.size() < 2) {
                throw new IllegalArgumentException("Ломанная линия не должна содержать null элементы и иметь минимум две точки");
            }
        }
        this.list = list;
        return this;
    }

    public PolyLine(List<Point> list) {
        this.setList(list);
    }

    public PolyLine(Point... points) {
        for (int i = 0; i < points.length; i++) {
            list.add(points[i]);
        }
        this.setList(list);
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PolyLine polyLine = (PolyLine) object;
        return Objects.equals(list, polyLine.list);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(list);
    }

    public int length() {
        if (list == null || list.size() < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            res += list.get(i).lengthTo(list.get(i + 1));
        }
        return res;
    }

    @Override
    public String toString() {
        return "Ломаная линия " + list;
    }
}

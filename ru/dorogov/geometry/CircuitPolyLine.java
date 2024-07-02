package ru.dorogov.geometry;

import java.util.List;

//3.1.2
public class CircuitPolyLine extends PolyLine {
    public CircuitPolyLine(Point... points) {
        super(points);
    }

    public CircuitPolyLine(List<Point> list) {
        super(list);
    }

    @Override
    public int length() {
        int res = super.length();
        if (list == null || list.size() < 3) {
            return res;
        }
        return res + list.get(list.size() - 1).lengthTo(list.get(0));
    }
}

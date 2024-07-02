package ru.dorogov.geometry;//3.1.2

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Lengthable {
    List<Point> list = new ArrayList<>();


    public PolyLine(List<Point> list) {
        this.list = list;
    }

    public PolyLine(Point... points) {
        for (int i = 0; i < points.length; i++) {
            list.add(points[i]);
        }
    }


    public int length() {
        if (list==null || list.size()<2) {
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
        return "Линия " + list;
    }
}

//3.1.2
import java.util.ArrayList;
import java.util.List;

public class PolyLine extends Lines{
    List<Point> list = new ArrayList<>();

    public PolyLine(List<Point> list) {
        this.list = list;
    }

    public PolyLine(Point... points) {
        for (int i = 0; i < points.length; i++) {
            list.add(points[i]);
        }
    }

    private int lengthTwo(Point p1, Point p2) {
        int i1 = p1.getX() - p2.getX();
        int i2 = p1.getY() - p2.getY();
        int length = i1 * i1 + i2 * i2;
        return (int) Math.sqrt(length);
    }

    public int length() {
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            res += lengthTwo(list.get(i), list.get(i + 1));
        }
        return res;
    }

    @Override
    public String toString() {
        return "Линия " + list;
    }
}

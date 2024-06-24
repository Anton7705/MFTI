import java.util.List;

//3.1.2
public class CirciutPolyLine extends PolyLine {
    public CirciutPolyLine(Point... points) {
        super(points);
    }

    public CirciutPolyLine(List<Point> list) {
        super(list);
    }

    private int lengthTwo(Point p1, Point p2) {
        int i1 = p1.getX() - p2.getX();
        int i2 = p1.getY() - p2.getY();
        int length = i1 * i1 + i2 * i2;
        return (int) Math.sqrt(length);
    }

    @Override
    public int length() {
        try {
            list.get(0);
        } catch (Exception e) {
            return 0;
        }
        return super.length() + lengthTwo(list.get(list.size() - 1), list.get(0));
    }
}

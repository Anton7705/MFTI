// 1.6.6
public class Line implements Lines{
    private Point p1;
    private Point p2;

    Line(Point p1, Point p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    Line(int x1, int x2, int y1, int y2) {
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
        this.p1 = new Point(p1.getX(), p1.getY());
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = new Point(p2.getX(), p2.getY());
    }
}

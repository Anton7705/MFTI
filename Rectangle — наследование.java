//3.2.4
public class Rectangle extends Figures {
    private int side1;
    private int side2;

    public Rectangle(Point p1, int side1, int side2) {
        super(p1);
        check(side1);
        check(side2);
        this.side1 = side1;
        this.side2 = side2;
    }

    public Rectangle(Point p1, int side1) {
        super(p1);
        check(side1);
        this.side1 = side1;
        this.side2 = side1;
    }

    private void check(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть больше 0");
        }
    }

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        check(side1);
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        check(side2);
        this.side2 = side2;
    }

    @Override
    public String toString() {
        if (side1 == side2) {
            return "Квадрат со сторонами " + side1;
        }
        return "Прямоугольник в точке " + getP1() + " со сторонами " + side1 + " и " + side2;
    }

    @Override
    public double findSquare() {
        return side1 * side2;
    }

    public boolean isSquare() {
        return side1 == side2;
    }
}

// 1.6.4
public class Fractions {
    private final int num1;
    private final int num2;

    Fractions(int num1, int num2) {
        if (num2 <= 0) {
            throw new IllegalArgumentException("знаменатель не может быть отрицательным или равным 0");
        }
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum1() {
        return num1;
    }

    @Override
    public String toString() {
        return num1 + "/" + num2;
    }

    public Fractions sum(Fractions f1) {
        int newNum1 = this.num1 * f1.num2 + f1.num1 * this.num2;
        int newNum2 = this.num2 * f1.num2;
        return new Fractions(newNum1, newNum2);
    }

    public Fractions sum(int i) {
        Fractions f1 = new Fractions(i, 1);
        return this.sum(f1);
    }

    public Fractions minus(Fractions f1) {
        int newNum1 = this.num1 * f1.num2 - f1.num1 * this.num2;
        int newNum2 = this.num2 * f1.num2;
        return new Fractions(newNum1, newNum2);
    }

    public Fractions minus(int i) {
        Fractions f1 = new Fractions(i, 1);
        return this.minus(f1);

    }

    public Fractions mult(Fractions f1) {
        int newNum1 = this.num1 * f1.num1;
        int newNum2 = this.num2 * f1.num2;
        return new Fractions(newNum1, newNum2);
    }

    public Fractions mult(int i) {
        Fractions f1 = new Fractions(i, 1);
        return this.mult(f1);
    }

    public Fractions div(Fractions f1) {
        int newNum1 = this.num1 * f1.num2;
        int newNum2 = this.num2 * f1.num1;
        return new Fractions(newNum1, newNum2);
    }

    public Fractions div(int i) {
        Fractions f1 = new Fractions(i, 1);
        return this.div(f1);
    }

}
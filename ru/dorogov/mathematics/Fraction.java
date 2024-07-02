package ru.dorogov.mathematics;

// 1.6.4
public class Fraction {
    private final int num;
    private final int denum;

    public Fraction(int num, int denum) {
        if (denum <= 0) {
            throw new IllegalArgumentException("знаменатель не может быть отрицательным или равным 0");
        }
        this.num = num;
        this.denum = denum;
    }

    public int getDenum() {
        return denum;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return num + "/" + denum;
    }

    public Fraction sum(Fraction f1) {
        int newNum1 = this.num * f1.denum + f1.num * this.denum;
        int newNum2 = this.denum * f1.denum;
        return new Fraction(newNum1, newNum2);
    }

    public Fraction sum(int i) {
        Fraction f1 = new Fraction(i, 1);
        return this.sum(f1);
    }

    public Fraction minus(Fraction f1) {
        int newNum1 = this.num * f1.denum - f1.num * this.denum;
        int newNum2 = this.denum * f1.denum;
        return new Fraction(newNum1, newNum2);
    }

    public Fraction minus(int i) {
        Fraction f1 = new Fraction(i, 1);
        return this.minus(f1);

    }

    public Fraction mult(Fraction f1) {
        int newNum1 = this.num * f1.num;
        int newNum2 = this.denum * f1.denum;
        return new Fraction(newNum1, newNum2);
    }

    public Fraction mult(int i) {
        Fraction f1 = new Fraction(i, 1);
        return this.mult(f1);
    }

    public Fraction div(Fraction f1) {
        int newNum1 = this.num * f1.denum;
        int newNum2 = this.denum * f1.num;
        return new Fraction(newNum1, newNum2);
    }

    public Fraction div(int i) {
        Fraction f1 = new Fraction(i, 1);
        return this.div(f1);
    }

}
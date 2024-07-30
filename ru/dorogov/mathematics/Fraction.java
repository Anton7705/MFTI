package ru.dorogov.mathematics;

import java.util.Objects;

// 1.6.4
public class Fraction implements Cloneable, Fractionable {
    private int num;
    private int denum;

    public Fraction(int num, int denum) {
        if (denum == 0) {
            throw new IllegalArgumentException("знаменатель не может быть равным 0");
        }
        this.num = num;
        this.denum = denum;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Fraction fraction)) return false;
        return num == fraction.num && denum == fraction.denum;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(num, denum);
    }

    public int getDenum() {
        return denum;
    }

    public int getNum() {
        return num;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void setDenum(int denum) {
        if (denum == 0) {
            throw new IllegalArgumentException("знаменатель не может быть равным 0");
        }
        this.denum = denum;
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

    @Override
    public double doubleValue() {
        System.out.println("TEST");
        return (double) num / denum;
    }


    @Override
    public Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }
}

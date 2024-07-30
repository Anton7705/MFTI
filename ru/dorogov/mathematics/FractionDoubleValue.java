package ru.dorogov.mathematics;

import java.util.ArrayList;
import java.util.List;

public class FractionDoubleValue implements Fractionable {
    Fraction f1;
    private int num;
    private int denum;
    private double x = Math.sqrt(2.0); // иррациональное число

    public FractionDoubleValue(Fraction f1) {
        this.f1 = f1;
        this.num = f1.getNum();
        this.denum = f1.getDenum();
    }

    @Override
    public void setNum(int num) {
        this.num = num;
        x = (double) num / denum;
    }

    @Override
    public void setDenum(int denum) {
        if (denum == 0) {
            throw new IllegalArgumentException("знаменатель не может быть равным 0");
        }
        this.denum = denum;
        x = (double) num / denum;
    }

    @Override
    public double doubleValue() {
        if (x == Math.sqrt(2.0)) {
            x = (double) num / denum;
        }
        return x;
    }
}

package ru.dorogov.mathematics;

public class FractionCache implements Fractionable {
    private Fraction f1;

    private Double cacheValue;

    public FractionCache(Fraction f1) {
        this.f1 = f1;

    }

    @Override
    public void setNum(int num) {
        f1.setNum(num);
        cacheValue = null;
    }

    @Override
    public void setDenum(int denum) {
        f1.setDenum(denum);
        cacheValue = null;
    }

    @Override
    public double doubleValue() {
        if (cacheValue == null) {
            cacheValue = f1.doubleValue();
        }
        return cacheValue;
    }
}

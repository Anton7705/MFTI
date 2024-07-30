package ru.dorogov.mathematics;

public class Main2 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1,2);
        FractionDoubleValue f2 = new FractionDoubleValue(f1);

        test(f2);
    }

    static void test (Fractionable fractionable) {
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
        fractionable.setNum(12);
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
        fractionable.setDenum(25);
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
        System.out.println(fractionable.doubleValue());
    }
}

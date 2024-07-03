package ru.dorogov.mathematics;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

//4.1.3
public class Сalculations {
    private Сalculations(){}
    public static double sumNumbers(Number... numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
//4.1.4
    public static double exponentiation(String x, String y) {
        int x1 = parseInt(x);
        int y1 = parseInt(y);
        return pow(x1,y1);
    }
}




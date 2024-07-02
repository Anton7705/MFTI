package ru.dorogov.mathematics;


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
        int x1 = Integer.parseInt(x);
        int y1 = Integer.parseInt(y);
        return Math.pow(x1,y1);
    }
}




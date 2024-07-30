package ru.dorogov.geometry;

// Базовый класс для методов
public class MethodsSum {
    private MethodsSum(){}
    //3.3.3
    public static double summSquare(Figure... figures) {
        double res = 0;
        for (int i = 0; i < figures.length; i++) {
            res += figures[i].findSquare();
        }
        return res;
    }
    //3.3.5
    public static int summOfLines(Lengthable... lines) {
        int res = 0;
        for (int i = 0; i < lines.length; i++) {
            res += lines[i].length();
        }
        return res;
    }
}

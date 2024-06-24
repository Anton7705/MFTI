// Базовый класс для методов
public abstract class Metods {
    //3.3.3
    public static double summSquare(Figures... figures) {
        double res = 0;
        for (int i = 0; i < figures.length; i++) {
            res += figures[i].findSquare();
        }
        return res;
    }
    //3.3.5
    public static int summOfLines(Lines... lines) {
        int res = 0;
        for (int i = 0; i < lines.length; i++) {
            res += lines[i].length();
        }
        return res;
    }
}

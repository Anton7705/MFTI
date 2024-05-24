public class Metods {
    public static void main(String[] args) {
        int x = lastNumSum(5,11);
        x = lastNumSum(x,123);
        x = lastNumSum(x,14);
        x = lastNumSum(x,1);
        System.out.println("Итого " + x);
    }
    // задача 2.1
    public static double fraction(double x) {
        int y = (int)x;
        return x - y;
    }

    // задача 2.2
    public static int sumLastNums(int x){
        int x1 = x / 10 % 10;
        int x2 = x %10;
        return x1 + x2;
    }

    // задача 2.3
    public static int charToNum(char x){
        int x1 = x - '0';
        return x1;
    }

    // задача 2.4
    public static boolean isPositive(int x){
        return x>0;
    }

    // задача 2.5
    public static boolean is2Digits(int x){
        return (x > 9 && x < 100) || (x < -9 && x > -100);
    }

    // задача 2.6
    public static boolean isUpperCase(char x){
        return x >= 'A' && x <= 'Z';
    };

    // задача 2.7
    public static boolean isInRange(int a, int b, int num) {
        return (a > b && (a - b) >= num) || (a<b && (b - a) >= num);
    }

    // задача 2.8
    public static boolean isDivisor (int a, int b){
        return a % b == 0 || b % a == 0;
    };

    // задача 2.9
    public static boolean isEqual (int a, int b, int c){
        return a == b && b == c && c == a;
    };

    // задача 2.10

    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }
};


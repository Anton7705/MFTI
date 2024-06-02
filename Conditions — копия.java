public class Conditions {
    // 3.1
    public static int abs(int x) {
        if (x >= 0) {
            return x;
        } else return -x;
    }

    // 3.2
    public static int safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        } else
            return x / y;
    }

    // 3.3
    public static int max(int x, int y) {
        if (x >= y) {
            return x;
        } else return y;
    }

    // 3.4
    public static String makeDecision(int x, int y) {
        if (x > y) {
            return x + " > " + y;
        } else if (x < y) {
            return x + " < " + y;
        } else return x + " == " + y;
    }

    // 3.5
    public static int max3(int x, int y, int z) {
        int count = x;
        if (count < y) {
            count = y;
        }
        if (count < z) {
            count = z;
        }
        return count;
    }

    // 3.6
    public static boolean sum3(int x, int y, int z) {
        int count1 = x + y;
        int count2 = x + z;
        int count3 = z + y;
        if (count1 == z || count2 == y || count3 == x) {
            return true;
        } else return false;
    }

    // 3.7
    public static int sum2(int x, int y) {
        if ((x + y) > 10 && (x + y) <= 20) {
            return 20;
        } else return x + y;
    }

    // 3.8
    public static boolean is35(int x) {
        if (x % 3 == 0 && x % 5 == 0) {
            return false;
        } else if (x % 3 == 0 || x % 5 == 0) {
            return true;
        } else return false;
    }

    // 3.9
    public static boolean magic6(int x, int y) {
        boolean flag = false;
        if ((x == 6 || y == 6) || (x + y == 6) || (x - y == 6)) {
            flag = true;
        }
        return flag;
    }

    // 3.10
    public static String age(int x) {
        int x1 = x % 10;
        if (x1 == 1 && x != 11) {
            return x + " год";
        }
        if ((x1 >= 2 && x1 <= 4) && !(x >= 12 && x <= 14)) {
            return x + " года";
        } else return x + " лет";
    }

    // 3.11
    public static String day(int x) {
        String s1;
        switch (x) {
            case 1:
                s1 = "понедельник";
                break;
            case 2:
                s1 = "вторник";
                break;
            case 3:
                s1 = "среда";
                break;
            case 4:
                s1 = "четверг";
                break;
            case 5:
                s1 = "пятница";
                break;
            case 6:
                s1 = "суббота";
                break;
            case 7:
                s1 = "воскресенье";
                break;
            default:
                s1 = "это не день недели";
        }
        return s1;
    }

    // 3.12
    public static void printDays(String x) {
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }
}


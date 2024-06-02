public class Cycles {
    // 4.1
    public static String listNums(int x) {
        String s = "";
        for (int i = 0; i <= x; i++) {
            String s1 = i + " ";
            s = s + s1;
        }
        return s;
    }

    // 4.2
    public static String reverseListNums(int x) {
        String s = "";
        for (int i = x; i >= 0; i--) {
            String s1 = i + " ";
            s = s + s1;
        }
        return s;
    }

    // 4.3
    public static String chet(int x) {
        String s = "";
        for (int i = 0; i <= x; i = i + 2) {
            String s1 = i + " ";
            s = s + s1;
        }
        return s;
    }

    // 4.4
    public static int pow(int x, int y) {
        int x1 = x;
        for (int i = 1; i < y; i++) {
            x1 = x1 * x;
        }
        return x1;
    }

    // 4.5
    public static int numLen(long x) {
        int count = 0;
        int i = 1;
        while ((x / i) != 0) {
            count++;
            i = i * 10;
        }
        if (x == 0) {
            count++;
        }
        return count;
    }

    // 4.6
    public static boolean equalNum(int x) {
        if (x < 10 && x > -10) {
            return true;
        }
        int first = x % 10;
        x = x / 10;

        while (x != 0) {
            if (x % 10 != first) {
                return false;
            }
            x = x / 10;
        }
        return true;
    }

    // 4.7
    public static void square(int x) {
        int j = 0;
        while (j < x) {
            for (int i = 0; i < x; i++) {
                System.out.print("*");
            }
            System.out.println();
            j++;
        }
    }

    // 4.8
    public static void leftTriangle(int x) {
        int j = 0;
        while (j < x) {
            for (int i = 0; i <= j; i++) {
                System.out.print("*");
            }
            System.out.println();
            j++;
        }
    }

    // 4.9
    public static void rightTriangle(int x) {
        int count = 1;
        int i1 = 1;
        int j = 0;
        while (j < x) {
            for (int i = 0; i <= j; i++) {
                while (i1 < x) {
                    System.out.print(" ");
                    i1++;
                }
                System.out.print("*");
            }
            System.out.println();
            j++;
            count++;
            i1 = i1 - x + count;
        }
    }

    // 4.10
    public static void guessGame() {
        int count = 1;
        int randomNum = 3;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("What number am I thinking (0 to 9)? :");
        int x = sc.nextInt();
        while (x != randomNum) {
            if (x != randomNum) {
                System.out.println("No, try again");
                x = sc.nextInt();
                count++;
            }
        }
        System.out.println("Yes, it`s " + randomNum);
        System.out.println("Number of attempts: " + count);
    }
}

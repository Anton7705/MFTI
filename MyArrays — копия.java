
public class MyArrays {
    // 5.1
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // 5.2
    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i != -1; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // 5.3
    public static int maxAbs(int[] arr) {
        int x = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] * arr[i] > x * x) {
                x = arr[i];
            }
        }
        return x;
    }

    // 5.4
    public static int countPositive(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }
        return count;
    }

    // 5.5
    public static boolean palindrom(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }

    // 5.6
    public static void reverse(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            arr1[i] = arr[j];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i];
        }
    }

    // 5.7
    public static int[] reverseBack(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            arr1[i] = arr[j];
        }
        return arr1;
    }

    // 5.8
    public static int[] concat(int[] arr1, int[] arr2) {
        int count = 0;
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
            count++;
        }
        for (int i = count, j = 0; i < arr3.length; i++, j++) {
            arr3[i] = arr2[j];
        }
        return arr3;
    }

    // 5.9
    public static int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        int[] arr2 = new int[count];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                arr2[j] = i;
                j++;
            }
        }
        return arr2;
    }

    // 5.10
    public static int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;
            }
        }
        int[] arr2 = new int[count];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                arr2[j] = arr[i];
                j++;
            }
        }
        return arr2;
    }

    // 5.11
    public static int[] add(int[] arr, int x, int pos) {
        if (pos < 0) {
            System.out.println("Некорректное значение переменной pos");
            return arr;
        }
        int count = 0;
        int[] arr2 = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
            count++;
            if (i == pos) {
                arr2[i] = x;
                break;
            }
        }
        for (int i = count; i < arr2.length; i++) {
            arr2[i] = arr[i - 1];
        }
        if (pos >= arr2.length - 1) {
            arr2[arr2.length - 1] = x;
            return arr2;
        }
        return arr2;
    }

    // 5.12
    public static int[] add(int[] arr, int[] ins, int pos) {
        if (pos < 0) {
            System.out.println("Некорректное значение переменной pos");
            return arr;
        }
        int count = 0;
        int[] arr2 = new int[arr.length + ins.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == pos) {
                for (int j = 0; j <= ins.length - 1; j++) {
                    arr2[count] = ins[j];
                    count++;
                }
            }
            arr2[count] = arr[i];
            count++;
        }
        if (pos >= arr.length) {
            for (int j = 0; j <= ins.length - 1; j++) {
                arr2[count] = ins[j];
                count++;
            }
            return arr2;
        }
        return arr2;
    }
}

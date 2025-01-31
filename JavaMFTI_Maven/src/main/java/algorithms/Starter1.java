package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Starter1 {

    public static int[] binSearchArrays(int[] array1, int[] array2) {
        int[] arrayFinal = new int[array2.length];
        for (int i = 0; i < arrayFinal.length; i++) {
            arrayFinal[i] = binSearchKey(array1, array2[i]);
        }
        return arrayFinal;
    }

    private static int binSearchKey(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left - 1 < right) {
            int mid = (right + left) / 2;
            if (array[mid] == key) {
                return mid + 1;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int[] intsToArray(Scanner scanner) {
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = intsToArray(scanner);

        int[] arr2 = intsToArray(scanner);

        int[] numbers = binSearchArrays(arr1, arr2);

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        scanner.close();
    }
}
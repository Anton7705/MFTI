package algorithms;

import java.util.Random;
import java.util.Scanner;

public class Starter3 {
    public static void QuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(array, left, right);
        QuickSort(array, left, p - 1);
        QuickSort(array, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int rand = new Random().nextInt(left, right + 1);
        int pivot = arr[rand];
        swap(arr, rand, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] > pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[scanner.nextInt()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        QuickSort(numbers, 0, numbers.length - 1);

        for (int number : numbers) {
            System.out.println(number);
        }

        scanner.close();
    }
}

package stepick;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Starter1 {
    public static void checkSortArrayLength(int[] n) {
        int count = 1;
        int maxCount = 0;
        for (int i = 1; i < n.length; i++) {
            if (n[i] < n[i - 1]) {
                if (maxCount <= count) {
                    maxCount = count;
                    count = 0;
                };
            }
            count++;
        }
        if (maxCount < count) {
            maxCount = count;
        };
        System.out.println(maxCount);
    }

    public static void main(String[] args) {
        int[] asd = {2, 1, 4, 1, 2, 3, 4 ,5, 6, 7, 3, 1};
        checkSortArrayLength(asd);
    }
}

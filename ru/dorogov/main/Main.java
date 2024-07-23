package ru.dorogov.main;

import ru.dorogov.Chapter5.*;
import ru.dorogov.education.*;
import ru.dorogov.geometry.Line;
import ru.dorogov.geometry.Point;
import ru.dorogov.geometry.Point3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 5.3.1
        List<Integer> arr = Work.map(List.of("qwerty", "asdfg", "zx"), i -> i.length());
        System.out.println(arr);
        List<Integer> arr1 = Work.map(List.of(1, -3, 7), i -> {
            if (i < 0) return -i;
            return i;
        });
        System.out.println(arr1);
        int[] i1 = {11, 2, 3, 4};
        int[] i2 = {-10, 23, 9, 40};
        int[] i3 = {11, 90, 30, 4};
        List<Integer> arr2 = Work.map(List.of(i1, i2, i3), i -> {
            int z = i[0];
            for (int j = 1; j < i.length; j++) {
                if (i[j] > z) {
                    z = i[j];
                }
            }
            return z;
        });
        System.out.println(arr2);


        // 5.3.2
        List<String> arr3 = Work.filter(List.of("qwerty", "asdfg", "zx"), i -> i.length() > 3);
        System.out.println(arr3);

        List<Integer> arr4 = Work.filter(List.of(1, -3, 7), i -> i < 0);
        System.out.println(arr4);

        List<int[]> arr5 = Work.filter(List.of(i1, i2, i3), i -> {
            for (int j = 0; j < i.length; j++) {
                if (i[j] < 0) {
                    return false;
                }
            }
            return true;
        });


        // 5.3.3
        String arr6 = Work.reduce(List.of("qwerty", "asdfg", "zx"), (x, y) -> x + y).get("");
        System.out.println(arr6);
        Integer i11 = Work.reduce(List.of(1, -3, 7), (x, y) -> x + y).get(0);
        System.out.println(i11);
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(List.of(1, 2, 3));
        listOfLists.add(List.of(4, 5, 6));
        Integer i22 = Work.reduce(Work.map(listOfLists, i -> i.size()), (x, y) -> x + y).get(0);
        System.out.println(i22);

        List<List<Integer>> l1 = Work.collect(List.of(1, -3, 7, -10, 10), () -> {
                    List<List<Integer>> list = new ArrayList<>();
                    list.add(new ArrayList<>());
                    list.add(new ArrayList<>());
                    return list;
                }, (list, num) -> {
                    if (num > 0) {
                        list.get(0).add(num);
                    } else if (num < 0) {
                        list.get(1).add(num);
                    }
                }
        );
        System.out.println(l1);

        List<List<String>> l2 = Work.collect(
                List.of("qwerty", "asdfg", "zx", "qw"),
                () -> {
                    List<List<String>> list = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        list.add(new ArrayList<>());
                    }
                    return list;
                },
                (list, str) -> list.get(str.length()).add(str)
        );

        System.out.println(l2);

        List<List<String>> l3 = Work.collect(List.of("qwerty", "asdfg", "qwerty", "qw"), () -> {
            List<List<String>> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new ArrayList<>());
            }
            return list;
        }, (list, num) -> {
            if (!list.get(num.length()).contains(num)) {
                list.get(num.length()).add(num);
            }
        });
        System.out.println(l3);
    }
}


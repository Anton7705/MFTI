package ru.dorogov.сhapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Hotness implements Comparable<Hotness> {
    private static List<Hotness> arr = new ArrayList<>();
    static {
        arr.add(new Hotness(0, "Not"));
        arr.add(new Hotness(50, "Medium"));
        arr.add(new Hotness(100, "Hot"));


    }
    final int grade;
    final String name;
    public static final Hotness Not = arr.get(0);
    public static final Hotness Medium = arr.get(1);
    private static final Hotness Hot = arr.get(2);;


    private Hotness(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public static Hotness getHotness(int grade) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).grade == grade) {
                return arr.get(i);
            }
        }
        throw new NoSuchElementException();
    }



    public static Hotness getHotness(String name) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).name.equals(name)) {
                return arr.get(i);
            }
        }
        throw new NoSuchElementException();
    }

//    public static Hotness create (int grade, String name) {
//        Hotness hotness = new Hotness(grade, name);
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i).grade == grade || arr.get(i).name.equals(name)) {
//                throw new IllegalArgumentException("This name is already exist");
//            }
//        }
//        arr.add(hotness);
//        return hotness;
//    }



    @Override
    public int compareTo(Hotness o) {
        return grade - o.grade;
    }
}

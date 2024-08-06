package ru.dorogov.main;


import ru.dorogov.сhapter5.*;
import ru.dorogov.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 5, 4, 4);
        List<String> list1 = List.of("1", "22", "333", "4444", "55555", "666666");
        String i = Work.creator(list1).map(x -> x + "YYY").filter(x -> x.length() > 22).filter(x -> x.length() > 6).reduce((x, y) -> x + y).get("qwerr");
        System.out.println(i);
    }
}

//        List<List<Integer>> i1 = Work.creator(list).map(x-> x+11).filter(x-> x> 0).filter(x -> x>0 ).collect(()-> {
//            List<List<Integer>> list11 = new ArrayList<>();
//            list11.add(new ArrayList<>());
//            list11.add(new ArrayList<>());
//            return list11;
//        }, (list11, num) -> {
//            if (num > 0) {
//                list11.get(0).add(num);
//            } else if (num < 0) {
//                list11.get(1).add(num);
//            }
//        });
//    }



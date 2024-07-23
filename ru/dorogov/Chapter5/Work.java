package ru.dorogov.Chapter5;

import java.util.ArrayList;
import java.util.List;

public class Work {

    public static <T, V> List<T> map(List<V> list, Operation<V, T> operation) {

        var list1 = new ArrayList<T>();
        for (V s : list) {
            list1.add(operation.make(s));
        }
        return list1;
    }

    public static <T> List<T> filter(List<T> list, Checker<T> checker) {
        var list1 = new ArrayList<T>();

        for (T s : list) {
            if (checker.check(s)) {
                list1.add(s);
            }
        }
        return list1;
    }

    public static <T> Storage<T> reduce(List<T> list, Summator<T> summator) {
        if (list == null || list.isEmpty()) {
            return Storage.create(null);
        }

        T res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = summator.make(res, list.get(i));
        }

        return Storage.create(res);
    }

    public static <T, P> P collect(List<T> list, CollectionCreator<P> creator, Collection<P, T> collector) {
        P result = creator.create();
        for (T element : list) {
            collector.add(result, element);
        }
        return result;
    }

}

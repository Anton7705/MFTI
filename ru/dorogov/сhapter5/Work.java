package ru.dorogov.сhapter5;


import java.util.ArrayList;
import java.util.List;

public class Work<T> {
    private List<T> list;
    private List<Keeper<T>> actions = new ArrayList<>();


    public static <T> Work<T> create(List<T> list) {
        return new Work<>(list);
    }

    private Work(List<T> list) {
        this.list = list;
    }

    public Work<T> filter(Checker<T> checker) {
        actions.add(new FilterKeeper<>(checker));
        return this;
    }

    public <V> Work<V> map(Operation<T, V> operation) {
        actions.add(new MapKeeper<>(operation));
        return (Work<V>) this;
    }



    public Storage<T> reduce(Summator<T> summator) {

        if (this.list == null || this.list.isEmpty()) {
            return Storage.create(null);
        }

        adding();

        if (list == null || list.isEmpty()) {
            return Storage.create(null);
        }

        T res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = summator.make(res, list.get(i));
        }

        return Storage.create(res);
    }

    public <P> P collect(CollectionCreator<P> creator, MyCollection<P, T> collector) {

        adding();

        P result = creator.create();
        for (T element : this.list) {
            collector.add(result, element);
        }
        return result;
    }

    private void adding() {
        for (int i = 0; i < actions.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                actions.get(i).apply(list.get(j));
            }
            list = actions.get(i).GetList();
        }
    }

}

package ru.dorogov.сhapter5;


import java.util.ArrayList;
import java.util.List;

public class Work<T> {
    private List<T> list;
    private List<Keeper<T>> actions;

    public Work<T> filter(Checker<T> checker) {
        actions.add(new FilterKeeper<>(checker));
        return this;
    }

    public Work<T> map(Operation<T, T> operation) {
        actions.add(new MapKeeper<>(operation));
        return this;
    }

    private void adding() {
        for (int i = 0; i < actions.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                actions.get(i).apply(list.get(j));
            }
            list = actions.get(i).GetList();
        }
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
        System.out.println(list);
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

    private Work(List<T> list) {
        this.list = list;
        this.actions = new ArrayList<>();
    }

    public static <T> Work<T> creator(List<T> list) {
        return new Work<>(list);
    }
}

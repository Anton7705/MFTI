package ru.dorogov.сhapter5;

import java.util.ArrayList;
import java.util.List;

public class MapKeeper<T, V> implements Keeper<T> {
    private Operation<T, V> operation;
    private List<V> listl = new ArrayList<>();

    public MapKeeper(Operation<T, V> operation) {
        this.operation = operation;
    }

    @Override
    public void apply(T value) {
        listl.add(operation.make(value));
    }

    @Override
    public List<V> GetList() {
        List<V> tmp  = listl;
        listl = null;
        return tmp;
    }
}

package ru.dorogov.сhapter5;

import java.util.ArrayList;
import java.util.List;

public class MapKeeper<T> implements Keeper<T> {
    private Operation<T, T> operation;
    private List<T> listl = new ArrayList<>();

    public MapKeeper(Operation<T, T> operation) {
        this.operation = operation;
    }

    @Override
    public void apply(T value) {
        listl.add(operation.make(value));
    }

    @Override
    public List<T> GetList() {
        return listl;
    }
}

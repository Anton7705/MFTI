package ru.dorogov.сhapter5;

import java.util.ArrayList;
import java.util.List;

public class FilterKeeper<T> implements Keeper<T> {
    private Checker<T> checker;
    private List<T> list = new ArrayList<>();

    public FilterKeeper(Checker<T> checker) {
        this.checker = checker;
    }
    @Override
    public void apply(T value) {
        if (checker.check(value)) {
            list.add(value);
        }
    }

    @Override
    public List<T> GetList() {
        return list;
    }
}

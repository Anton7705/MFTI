package ru.dorogov.сhapter5;

import java.util.List;

public interface Keeper<T> {
    void apply(T value);
    List<T> GetList();
}
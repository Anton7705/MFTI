package ru.dorogov.сhapter5;

import java.util.function.Consumer;

public interface Operation<T, V> {
    V make(T t);
}

package ru.dorogov.Chapter5;

public interface Operation<T, V> {
    V make(T t);
}

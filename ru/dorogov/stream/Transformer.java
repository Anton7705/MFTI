package ru.dorogov.stream;

public interface Transformer<T> {
    T transform (T t);
}

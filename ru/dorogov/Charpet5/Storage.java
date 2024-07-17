package ru.dorogov.Charpet5;
// 5.1.2
public class Storage<T> {
    private final T item;

    private Storage(T t) {
        this.item = t;
    }

    public static <T> Storage<T> create(T t) {
        return new Storage<>(t);
    }

    public T get(T t) {
        if (item == null) {
            return t;
        }
        return item;
    }
}

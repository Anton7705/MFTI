package ru.dorogov.сhapter5;

import java.util.function.Supplier;

public class StorageModified<T>  {
    private T tmp = null;
    private final Supplier<T> getter;

    private StorageModified(Supplier<T> getter) {
        this.getter = getter;
    }

    public static <T> StorageModified<T> create(Supplier<T> getter) {
        return new StorageModified<>(getter);
    }

    public T get(T t) {
        if (tmp == null) {
            tmp = getter.get();
            if (tmp != null) {
                return tmp;
            } else return t;
        }
        return tmp;
    }
}


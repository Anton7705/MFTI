package ru.dorogov.сhapter5;

import java.util.function.Supplier;

public class StorageModified<T> implements Supplier<T> {
    private T tmp = null;
    private final Supplier<T> getter;

    private StorageModified(Supplier<T> getter) {
        this.getter = getter;
    }

    public static <T> StorageModified<T> create(Supplier<T> getter) {
        return new StorageModified<>(getter);
    }

    @Override
    public T get() {
        if (tmp == null) {
            tmp = getter.get();
            return tmp;
        }
        return tmp;
    }
}


package ru.dorogov.Chapter5;
// 5.1.1
public class Box<T> {
    private T item;

    private Box(T item) {
        this.item = item;
    }

    public static <V> Box<V> create (V v) {
        return new Box<>(v);
    }

    public void set(T newItem) {
        if (this.item != null) {
            throw new IllegalStateException("The box is already filled");
        }
        this.item = newItem;
    }

    public T get() {
        T tempItem = this.item;
        this.item = null;
        return tempItem;
    }

    public boolean isEmpty() {
        return this.item == null;
    }

}

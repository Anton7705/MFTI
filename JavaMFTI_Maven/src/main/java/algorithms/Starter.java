package algorithms;

import java.util.*;

class MyArrayList<K> {
    public K[] array = (K[]) new Object[10];
    private int size = 0;

    public void pushBack(K element) {
        if (size == array.length) {
            K[] newArray = (K[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public K popBack() {
        if (size - 1 < 0) {
            throw new RuntimeException("Невозможно удалить элемент из пустого массива");
        }
        K k = array[--size];
        array[size] = null;
        return k;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    public K get(int i) {
        if (i >= size || i < 0) {
            throw new RuntimeException("Такого элемента не существует");
        }
        return array[i];
    }

    public K change(int i, K elem) {
        if (i >= size || i < 0) {
            throw new RuntimeException("Такого элемента не существует");
        }
        array[i] = elem;
        return array[i];
    }
}

public class Starter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        for (int j = 0; j < i; j++) {
            String string = sc.next();
            if (string.equals("push_back")) {
                myArrayList.pushBack(sc.nextInt());
            }
            if (string.equals("pop_back")) {
                System.out.println(myArrayList.popBack());
            }
            if (string.equals("size")) {
                System.out.println(myArrayList.size());
            }
            if (string.equals("index")) {
                System.out.println(myArrayList.get(sc.nextInt()));
            }
        }

        sc.close();
    }
}

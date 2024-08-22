package ru.dorogov.сhapter5;


import java.util.function.Supplier;

public class M {
    public static void main(String[] args) {
        Supplier getter =()-> 5;
        StorageModified s = StorageModified.create(getter);
        System.out.println(s.get());
    }
}



class TmpObject {
    public static StorageModified<Integer> count() {
        System.out.println("-------");
        int x = 5;
        int y = 10;
        int z = 15;
        return StorageModified.create(() -> y+z);
    }
}

class A {

    public A(Integer... integers) {

    }
}





package ru.dorogov.main;


import ru.dorogov.reflection.Default;
import ru.dorogov.reflection.Testing;
import ru.dorogov.reflection.UtilClass;
import ru.dorogov.geometry.Point;
import ru.dorogov.reflection.Validate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

//        HashMap<Class<?>, Object> defaultValues = new HashMap<>();
//
//        defaultValues.put(Integer.class, 10);
//        defaultValues.put(Double.class, 15.0);
//        defaultValues.put(String.class, "Hello");
//        defaultValues.put(char.class, 'W');
//
//        A a1 = new A();
//        A a2 = new A();
//        UtilClass.reset(defaultValues, a1);
//        defaultValues.put(char.class, 'P');
//        UtilClass.reset(defaultValues, a2);
//        System.out.println(a1);
//
//        UtilClass.validateVer2(new SomeEntity("A"));

        Testing t = new T();
        t = UtilClass.cache(t);
        int i = t.i();
        int i1 = t.i();
        int i2 = t.i();
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);

    }
}


class T implements Testing {
    @Override
    public void foo() {
        System.out.println("BOB");
    }

    public int x = 55;
    @Override
    public int i() {
        return x;
    }
}

@Validate(EntityTests.class)
class SomeEntity {
    public String name;

    public SomeEntity(String name) {
        this.name = name;
    }

    public static void hello() {
        System.out.println("HELLO");
    }
}

class EntityTests {
    public static void testNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object should be not null.");
        }
    }

    public static void testIsValid(Object obj) {
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException("Object must be instance of Number.");
        }
    }

    public static void testNotNull1(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("AAAAAAAAAA");
        }
    }
}

class A extends B {
    @Default
    public String name;
    @Default
    public Integer i;
    @Default
    public Integer i5;
    @Default
    Point p1;
    @Default
    Double d1;
    double d2;

    @Override
    public String toString() {
        return name + "\n" + i + "\n" + d1 + "\n" + i5 + "\n" + c1;
    }

}

@Default
class B {
    @Default
    public char c1;

    @Override
    public String toString() {
        return c1 + "";
    }
}

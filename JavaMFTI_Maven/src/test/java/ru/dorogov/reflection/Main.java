package ru.dorogov.reflection;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        makeTests(TestReflection.class);

    }

    public static void makeTests(Class clz) throws InstantiationException, IllegalAccessException {
        Object object = clz.newInstance();
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(object);
                    System.out.println(method.getName() + "+");
                } catch (Exception ex) {
                    Throwable testEx = ex.getCause();
                    if (testEx.equals(AssertionFailedError.class)) {
                        System.out.println("Тест не пройден");
                    } else System.out.println(ex.getCause());
                }
            }
        }
    }
}

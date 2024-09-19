package ru.dorogov.reflection;


import ru.dorogov.сhapter5.Methods;

import java.lang.reflect.*;
import java.util.*;


public class UtilClass {


//7.3.2
    public static void reset(HashMap<Class<?>, Object> defaultVal, Object... objects) {

        final HashMap<Class<?>, Object> defaultValues = defaultVal;

        for (int i = 0; i < objects.length; i++) {
            Class<?> clazz = objects[i].getClass();

            List<Field> filedsList = new ArrayList<>(List.of(objects[i].getClass().getDeclaredFields()));
            filedsList.addAll(List.of(objects[i].getClass().getFields()));
            filedsList = filedsList.stream().distinct().toList();


            for (Field f : filedsList) {
                f.setAccessible(true);
                if (clazz.isAnnotationPresent(Default.class)) {
                    if (defaultValues.get(f.getType()) == null) {
                        continue;
                    }
                    try {
                        f.set(objects[i], defaultValues.get(f.getType()));
                        continue;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (f.isAnnotationPresent(Default.class)) {
                    try {
                        f.set(objects[i], defaultValues.get(f.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    // 7.3.4
    public static void validateVer2(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].getClass().isAnnotationPresent(Validate.class)) {
                Class clazz = objects[i].getClass().getAnnotation(Validate.class).value();
                validate(objects[i], clazz);
            }
        }
    }

    //7.14
    private static void validate(Object object, Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(Object.class)) {
                try {
                    method.invoke(object, object);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } else throw new RuntimeException("Не подходит для проверки");
        }
    }


    // 7.1.6

    public static <T> T cache(T object) throws InvocationTargetException, IllegalAccessException {
        T t = (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new Cache(object));
        return t;
    }
}

class Cache implements InvocationHandler {
    Object ob;
    Object obj = null;

    public Cache(Object ob) {
        this.ob = ob;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (args == null) {
            if (obj == null) {
                obj = method.invoke(ob);
            }
            return obj;
        }
        return method.invoke(ob, args);
    }
}



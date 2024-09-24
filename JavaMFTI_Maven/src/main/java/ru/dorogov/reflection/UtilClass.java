package ru.dorogov.reflection;


import lombok.SneakyThrows;

import java.lang.reflect.*;
import java.util.*;


public class UtilClass {


//7.3.2

    @SneakyThrows
    static HashMap<Class<?>, Object> findAllFields(Class value) {
        Object o = value.newInstance();
        Method[] methods = value.getDeclaredMethods();
        HashMap<Class<?>, Object> map = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getReturnType() != void.class) { // test4
                Object object = methods[i].invoke(o);
                map.put(object.getClass(), object);
            }
        }
        return map;
    }

    static List<Field> getAllField(Class clz) {
        if (clz.equals(Object.class)) return new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        fields.addAll(List.of(clz.getDeclaredFields()));
        fields.addAll(getAllField(clz.getSuperclass()));
        return fields;
    }

    @SneakyThrows
    public static void reset(Object... objects) {

        for (Object object : objects) {
            Class<?> clazz = object.getClass();

            List<Field> filedsList = getAllField(clazz); // test1

            for (Field f : filedsList) {
                f.setAccessible(true);
                Default annotation = f.getAnnotation(Default.class); // test2
                if (annotation == null) annotation = clazz.getAnnotation(Default.class); // test3
                if (annotation == null) continue;
                HashMap<Class<?>, Object> defaultVal = findAllFields(annotation.value());
                if (!defaultVal.containsKey(f.getType())) {
                    continue;
                }
                try {
                    f.set(object, defaultVal.get(f.getType()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 7.3.4
    public static void validateVer2(Object... objects) {
        for (Object object : objects) {
            if (object.getClass().isAnnotationPresent(Validate.class)) {
                Class clazz = object.getClass().getAnnotation(Validate.class).value();
                validate(object, clazz);
            }
        }
    }

    //7.14
    @SneakyThrows
    private static void validate(Object object, Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        Object object1 = clazz.newInstance();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getParameterCount() == 1) {
                try {
                    method.invoke(object1, object);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } else throw new RuntimeException("Не подходит для проверки");
        }
    }


    // 7.1.6

    public static <T> T cache(T object) {
        T t = (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new CacheHandler(object));
        return t;
    }
}

class CacheHandler implements InvocationHandler {
    Map<Method, Object> cache = new HashMap<>();
    Object ob;

    public CacheHandler(Object ob) {
        this.ob = ob;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Method m = ob.getClass().getMethod(method.getName(), method.getParameterTypes());

        if (m.isAnnotationPresent(Mutator.class)) cache.clear();

        if (!m.isAnnotationPresent(Cache.class)) {
            return method.invoke(ob, args);
        }

        if (cache.containsKey(method)) {
            return cache.get(method);
        }

        Object res = method.invoke(ob, args);
        cache.put(method, res);
        return res;
    }
}



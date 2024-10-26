package ru.dorogov.reflection;


import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.*;
import java.util.*;


public class UtilClass {


//7.3.2

    @SneakyThrows
    public HashMap<Class<?>, Object> findAllObjects(Class value) {
        Object o = value.newInstance();
        Method[] methods = o.getClass().getDeclaredMethods();
        HashMap<Class<?>, Object> map = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getReturnType() != void.class) {
                methods[i].setAccessible(true);
                Object object = methods[i].invoke(o);
                map.put(object.getClass(), object);
            }
        }
        return map;
    }

    public List<Field> getAllFields(Class clz) {
        if (clz.equals(Object.class)) return new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        fields.addAll(List.of(clz.getDeclaredFields()));
        fields.addAll(getAllFields(clz.getSuperclass()));
        return fields;
    }

    //7.14
    @SneakyThrows
    void validate(Object object, Class<?> clazz) {
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
    @SneakyThrows
    public Object invoke(Object proxy, Method method, Object[] args) {

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



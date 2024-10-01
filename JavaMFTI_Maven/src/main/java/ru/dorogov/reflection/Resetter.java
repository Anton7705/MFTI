package ru.dorogov.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;



public class Resetter {
    static UtilClass utilClass = new UtilClass();

    @SneakyThrows
    public static void reset(Object... objects) {

        for (Object object : objects) {
            Class<?> clazz = object.getClass();

            List<Field> filedsList = utilClass.getAllFields(clazz);

            for (Field f : filedsList) {
                f.setAccessible(true);
                Default annotation = f.getAnnotation(Default.class);
                if (annotation == null) annotation = clazz.getAnnotation(Default.class);
                if (annotation == null) continue;
                HashMap<Class<?>, Object> defaultVal = utilClass.findAllObjects(annotation.value());
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
}

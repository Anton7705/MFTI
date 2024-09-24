package ru.dorogov.reflection;

import java.lang.reflect.Field;

public class MyObject extends Object implements Cloneable {
    @Override
    public String toString() {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            String res = "{";
            for (Field f : fields) {
                if (!f.isAnnotationPresent(Default.class)) continue;
                f.setAccessible(true);
                res += f.getName() + ":" + f.get(this) + " ";
            }
            return this.getClass().getName() + res + "}";
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

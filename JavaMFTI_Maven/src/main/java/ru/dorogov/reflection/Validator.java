package ru.dorogov.reflection;

public class Validator {
    static UtilClass utilClass = new UtilClass();

    public static void validateVer2(Object... objects) {
        for (Object object : objects) {
            if (object.getClass().isAnnotationPresent(Validate.class)) {
                Class clazz = object.getClass().getAnnotation(Validate.class).value();
                utilClass.validate(object, clazz);
            }
        }
    }
}

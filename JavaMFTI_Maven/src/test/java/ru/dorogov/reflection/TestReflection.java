package ru.dorogov.reflection;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class TestReflection {

    MonkeyForTestingReflection monkey;

    @Test
    @DisplayName("Fields check")
    @SneakyThrows
    void test1() {
        boolean b1 = false;
        List<Field> fields = MonkeyForTestingReflection.getAllField(MonkeyForTestingReflection.class);
        Field fields1 = monkey.getClass().getDeclaredField("s");
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).equals(fields1)) {
                b1 = true;
            }
        }
        if (!b1) throw new AssertionFailedError("Not all fields have been taken");
    }

    @Test
    @DisplayName("Private fileds check")
    @SneakyThrows
    void test2(){
        Field fields1 = monkey.getClass().getDeclaredField("s");
        if (!fields1.isAnnotationPresent(Default.class)) {
            throw new AssertionFailedError("Can not find annotation in private fields");
        }
    }

    @Test
    @DisplayName("Class annotation check")
    void test3() {
        Assertions.assertTrue(monkey.getClass().isAnnotationPresent(Default.class));
    }

    @Test
    @DisplayName("HashMap check")
    @SneakyThrows
    void test4() {
        HashMap<Class<?>, Object> map = MonkeyForTestingReflection.findAllFields(MonkeyForTestingReflection.class);
        if (map.containsKey(null)) throw new AssertionFailedError("Key in the map should not be null");
    }



    @BeforeEach
    void createTestingObj() {
        monkey = new MonkeyForTestingReflection();
    }
}

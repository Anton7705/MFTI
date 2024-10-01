package ru.dorogov.reflection;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestReflection {

    MonkeyForTestingReflection monkey;
    MyUtilClass myUtilClass;

    @Test
    @DisplayName("Finding all fields from class by UtilClass.getAllFields")
    void test1() {
        List<Field> fields = myUtilClass.getAllFields(MonkeyForTestingReflection.class);
        Field[] fields1 = monkey.getClass().getDeclaredFields();
        List<Field> testfileds = new ArrayList<>();
        testfileds.addAll(Arrays.stream(fields1).toList());
        Assertions.assertTrue(fields.containsAll(testfileds));

    }

    @Test
    @DisplayName("Finding all fields from super class by UtilClass.getAllFields")
    void test2() {
        List<Field> fields = myUtilClass.getAllFields(MonkeyForTestingReflection.class);
        Field[] fields1 = monkey.getClass().getSuperclass().getDeclaredFields();
        Field[] fields2 = monkey.getClass().getSuperclass().getSuperclass().getDeclaredFields();
        List<Field> testfileds = new ArrayList<>();
        testfileds.addAll(Arrays.stream(fields1).toList());
        testfileds.addAll(Arrays.stream(fields2).toList());
        Assertions.assertTrue(fields.containsAll(testfileds));
    }

    @Test
    @DisplayName("Finding all methods from Config class by UtilClass.findAllObjects without super class methods")
    void test3() {
        HashMap<Class<?>, Object> map = myUtilClass.findAllObjects(Config.class);
        assertEquals(4, map.size());
    }

    @Test
    @DisplayName("HashMap includes all keys from Config class without super class")
    void test4() {
        HashMap<Class<?>, Object> map = myUtilClass.findAllObjects(Config.class);
        assertTrue(map.containsKey(Integer.class) && map.get(Integer.class).equals(23));
        assertTrue(map.containsKey(String.class) && map.get(String.class).equals("A"));
        assertTrue(map.containsKey(Double.class) && map.get(Double.class).equals(11.11));
        assertTrue(map.containsKey(Long.class) && map.get(Long.class).equals(12345L));
        assertFalse(map.containsKey(Boolean.class));
    }

    @Test
    @DisplayName("HashMap check")
    @SneakyThrows
    void test5() {
        HashMap<Class<?>, Object> map = myUtilClass.findAllObjects(MonkeyForTestingReflection.class);
        if (map.containsKey(null)) throw new AssertionFailedError("Key in the map should not be null");
    }

    @Test
    @DisplayName("Assigning default values to all fields")
    void test6() {
        TestResetAnnotations testReset = new TestResetAnnotations();
        Resetter.reset(testReset);
        assertTrue(testReset.age == null);
        assertTrue(testReset.getName().equals("A"));
        assertTrue(testReset.getWeight().equals(11.11));
    }


    @Test
    @DisplayName("Assigning default values to all fields (Annotation on class)")
    void test7() {
        TestResetClassAnnotations testReset = new TestResetClassAnnotations();
        Resetter.reset(testReset);
        assertTrue(testReset.age.equals(23));
        assertTrue(testReset.height.equals(12345L));
        assertTrue(testReset.getName().equals("A"));
        assertTrue(testReset.getWeight().equals(11.11));
    }

    @BeforeEach
    void createTestingObj() {
        monkey = new MonkeyForTestingReflection();
        myUtilClass = new MyUtilClass();
    }

}


class TestReflectionValidate {

    MyUtilClass myUtilClass;
    SomeEntity testValidate;

    @Test
    @DisplayName("Invoking all methods")
    void test1() {
        myUtilClass.validate(testValidate, EntityTest.class);
        assertEquals("Alex", testValidate.name);
        assertEquals(55, testValidate.age);
        if (EntityTest.class.getDeclaredMethods().length != 4) {
            throw new AssertionFailedError("Not all methods were invoked");
        }
    }

    @Test
    @DisplayName("Method parameters check")
    void test2() {
        Validator.validateVer2(testValidate);
        Class clz = SomeEntity.class.getAnnotation(Validate.class).value();
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getParameterCount() != 1) {
                throw new AssertionFailedError("Methods must take one parameter");
            }
        }
    }

    @BeforeEach
    void createTestingObj() {
        myUtilClass = new MyUtilClass();
        testValidate = new SomeEntity("Hello");
    }
}

class TestReflectionCache {
    Able TestCache;
    MyUtilClass myUtilClass;

    @Test
    @DisplayName("Mutator cashe clean check")
    void cache() {
        int x1 = TestCache.integerX();
        TestCache.setx(1200);
        x1 = TestCache.integerX();
        Assertions.assertTrue(x1 == 1200);
    }

    @Test
    @DisplayName("Cashe check")
    void cache2() {
        double y1 = TestCache.doubleY();
        TestCache.sety(111.1);
        y1 = TestCache.doubleY();
        Assertions.assertTrue(y1 == 99.9);
    }

    @Test
    @DisplayName("Methods without annotation check")
    void cache3() {
        float f1 = TestCache.aFloat();
        TestCache.setF(55.55F);
        f1 = TestCache.aFloat();
        Assertions.assertTrue(f1 == 55.55F);
    }

    @BeforeEach
    void createTestingObj() {
        myUtilClass = new MyUtilClass();
        Able A = new A();
        TestCache = myUtilClass.cache(A);
    }
}
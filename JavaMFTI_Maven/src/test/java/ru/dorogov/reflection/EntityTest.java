package ru.dorogov.reflection;

import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
class EntityTestFather {
    public void testIsValid(Object obj) {
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException("Object must be instance of Number.");
        }
    }
}
public class EntityTest {
    public static int count;
    private void testNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object should be not null.");
        }
        count++;
    }

    public void testIsValid(Object obj) {
        if (!(obj instanceof SomeEntity)) {
            throw new IllegalArgumentException("Object must be instance of SomeEntity.");
        }
        count++;
    }

    void setName(SomeEntity someEntity) {
        someEntity.name = "Alex";
        count++;
    }

    void setAge(SomeEntity someEntity) {
        someEntity.age = 55;
        count++;
    }

}


@Validate(EntityTest.class)
class SomeEntity {
    public String name;

    int age = 10;
    public SomeEntity(String name) {
        this.name = name;
    }
}


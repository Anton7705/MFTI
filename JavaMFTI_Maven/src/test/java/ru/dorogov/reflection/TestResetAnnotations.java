package ru.dorogov.reflection;

import lombok.Getter;


public class TestResetAnnotations extends TestResetFather{
    @Getter
    @Default private String name;
    public static Integer age;
}


class TestResetFather {

    public Double getWeight() {
        return weight;
    }

    @Default private static Double weight;
    Long height;
}


@Default
class TestResetClassAnnotations extends TestResetFather {
    @Getter
    private String name;
    public static Integer age;
}

package ru.dorogov.reflection;

class ConfigTest {
    Boolean aBoolean () {
        return true;
    }
}

public class Config extends ConfigTest {
    private Integer defaultForInt() {
        return 23;
    }
    public static String defaultForString () {
        return "A";
    }

    protected Double defaultForDouble () {
        return 11.11;
    }

    Long defaultFotLong () {
        return 12345L;
    }
}

class Congig2 {
    void test () {
        System.out.println("test");
    }
}
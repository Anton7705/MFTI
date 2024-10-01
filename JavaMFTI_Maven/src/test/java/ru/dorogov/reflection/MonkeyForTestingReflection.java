package ru.dorogov.reflection;


@Default
class MonkeyGrandfather {
    public int age;
    protected Object object;
}

class MonkeyFather extends MonkeyGrandfather {
    private static String name;
    private static int weight;
}

public class MonkeyForTestingReflection extends MonkeyFather {
    @Default
    String s = "BOB";

    Integer test1() {
        return 99;
    }

    void setS() {
        System.out.println("aaa");
    }
}

package ru.dorogov.reflection;

import org.junit.jupiter.api.Test;
@Default
public class MonkeyForTestingReflection extends UtilClass {
    @Default private String s = "BOB";

    Integer test1() {
        return 99;
    }
    void setS (){
        System.out.println("aaa");
    }
}

package ru.dorogov.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class CacheHandlerTest implements Able {
    int x = 100;
    double y = 99.9;
    float f = 12.12F;

    @Override
    @Cache
    public int integerX() {
        return x;
    }

    @Override
    @Cache
    public double doubleY() {
        return y;
    }

    @Override
    public float aFloat () {
        return f;
    }

    @Override
    public void setF(float f) {
        this.f = f;
    }

    @Override
    @Mutator
    public void setx(int x) {
        this.x = x;
    }

    @Override
    public void sety(double x) {
        this.y = y;
    }
}
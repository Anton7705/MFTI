package ru.dorogov.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext ctx =new AnnotationConfigApplicationContext("ru.dorogov.trafficLight");
        TrafficLight tl = ctx.getBean(TrafficLight.class);
        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.waiting();
        tl.next();
        tl.next();
        tl.next();
    }
}


@Component("TrafficLight")
class TrafficLight {

    private Color cur;

    @Autowired
    @Qualifier("red")
    void setCur(Color cur) {
        this.cur = cur;
    }

    public void next() {
        System.out.println(cur);
        cur = cur.next();
    }

    public void waiting() {
        cur = new yBlack();
    }

    public void on() {
        cur = new Red();
    }
}


interface Color {
    Color next();
}

@Component
class Red implements Color {
    public Color next() {
        return new YRed();
    }

    @Override
    public String toString() {
        return "RED";
    }
}

@Component
class Green implements Color {
    public Color next() {
        return new YGreen();
    }

    @Override
    public String toString() {
        return "GREEN";
    }
}

@Component
class YGreen implements Color {
    public Color next() {
        return new Red();
    }

    @Override
    public String toString() {
        return "YELLOW";
    }
}

@Component
class YRed implements Color {
    public Color next() {
        return new Green();
    }

    @Override
    public String toString() {
        return "YELLOW";
    }
}

@Component
class yBlack implements Color {
    public Color next() {
        return new bYellow();
    }

    @Override
    public String toString() {
        return "Black";
    }
}

@Component
class bYellow implements Color {
    public Color next() {
        return new yBlack();
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}
package ru.dorogov.trafficLight;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext ctx =new AnnotationConfigApplicationContext("ru.dorogov.trafficLight");
        TrafficLight tl = ctx.getBean(TrafficLight.class);
//        tl.on();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
//        tl.waiting();
        tl.next();
        tl.next();
        tl.next();
    }
}


@Component("TrafficLight")
class TrafficLight {

    @Autowired
    @Qualifier("Red")
    private Color base;

    private Color cur;

    @Autowired
    @Qualifier("yBlack")
    private yBlack waitingColor;

    public void next() {
        System.out.println(cur);
        cur = cur.next();
    }

    public void waiting() {
        cur = waitingColor;
    }

    @PostConstruct
    public void on() {
        cur = base;
    }
}


interface Color {
    Color next();
}

@Component
@Qualifier("Red")
class Red implements Color {
    @Autowired
    @Qualifier("YRed")
    Color next;
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "RED";
    }
}

@Component
@Qualifier("Green")
class Green implements Color {
    @Autowired
    @Qualifier("YGreen")
    Color next;
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "GREEN";
    }
}

@Component
class YGreen implements Color {
    @Autowired
    @Qualifier("Red")
    Color next;
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "YELLOW";
    }
}

@Component
class YRed implements Color {
    @Autowired
    @Qualifier("Green")
    Color next;
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "YELLOW";
    }
}

@Component
class yBlack implements Color {
    @Autowired
    @Qualifier("bYellow")
    Color next;
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "Black";
    }
}

@Component
class bYellow implements Color {
    @Autowired
    @Qualifier("yBlack")
    Color next;
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}
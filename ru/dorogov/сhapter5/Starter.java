package ru.dorogov.сhapter5;

public class Starter {
    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight();
        tl.next();
        tl.next();
        tl.next();
        tl.waiting();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.on();
        tl.next();
        tl.next();
    }
}

class TrafficLight {
    private Color cur = new Red();

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

class Red implements Color {
    public Color next() {
        return new YRed();
    }

    @Override
    public String toString() {
        return "RED";
    }
}

class Green implements Color {
    public Color next() {
        return new YGreen();
    }

    @Override
    public String toString() {
        return "GREEN";
    }
}

class YGreen implements Color {
    public Color next() {
        return new Red();
    }

    @Override
    public String toString() {
        return "YELLOW";
    }
}

class YRed implements Color {
    public Color next() {
        return new Green();
    }

    @Override
    public String toString() {
        return "YELLOW";
    }
}

class Black implements Color {
    public Color next() {
        return this;
    }
}

class yBlack implements Color {
    public Color next() {
        return new bYellow();
    }
    @Override
    public String toString() {
        return "Black";
    }
}

class bYellow implements Color {
    public Color next() {
        return new yBlack();
    }
    @Override
    public String toString() {
        return "Yellow";
    }
}

package ru.dorogov.сhapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class KarateBoy {
    String name;

    public KarateBoy(String name) {
        this.name = name;
    }

    public void kick() {
        System.out.println(name + ": kick!!!!");
    }

    public void punch() {
        System.out.println(name + ": kiyaaaaaaaa!!!");
    }

    public void jump() {
        System.out.println(name + ": AAAA!!");
    }

}


class Combo implements Kick<KarateBoy> {
    List<Kick<KarateBoy>> list = new ArrayList<>();

    @Override
    public void make(KarateBoy kb) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).make(kb);
        }
    }
}

class Punch implements Kick<KarateBoy> {
    @Override
    public void make(KarateBoy karateBoy) {
        karateBoy.punch();
    }

    public static void main(String[] args) {
        Combo combo = new Combo();
        KarateBoy k1 = new KarateBoy("Sasha");
        combo.list.add(x -> x.kick());
        combo.list.add(x -> x.jump());
        combo.make(k1);
        Combo combo2 = new Combo();
        combo2.list.add(x -> combo.make(x));
        combo2.list.add(x -> x.punch());
        combo2.make(k1);
        System.out.println("-------");


        Predicate<String> predicate = (x -> x.length() > 22);
        System.out.println(predicate.test("{POKJHGFDKLJHGF"));
    }
}
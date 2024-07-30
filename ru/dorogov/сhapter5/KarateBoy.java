package ru.dorogov.сhapter5;

import ru.dorogov.education.Student;

import java.util.ArrayList;
import java.util.List;

public class KarateBoy{
    String name;

    public KarateBoy(String name) {
        this.name = name;
    }
    public void kick(){
        System.out.println(name+": kick!!!!");
    }
    public void punch(){
        System.out.println(name+": kiyaaaaaaaa!!!");
    }
    public void jump(){
        System.out.println(name+": AAAA!!");
    }

}

class Main {
    public static void main(String[] args) {
        KarateBoy kb = new KarateBoy("BOB");
        Combo combo1 = new Combo();
        Combo combo2 = new Combo();
        combo1.list.add(x -> x.kick());
        combo1.list.add(x -> x.punch());
        combo1.list.add(x -> x.jump());
        combo1.make(kb);
        combo2.list.add(x -> combo1.make(x));
        combo2.list.add(combo1);
        combo2.make(kb);

        Student s1 = new Student("BOB", x -> x > 2 && x < 5, 3,4);

    }
}

class Combo implements Kick<KarateBoy> {
    List<Kick<KarateBoy>> list = new ArrayList<>();
    public void make (KarateBoy kb) {
        for (Kick<KarateBoy> c : list) {
            c.make(kb);
        }
    }

}

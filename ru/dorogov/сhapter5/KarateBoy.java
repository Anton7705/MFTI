package ru.dorogov.сhapter5;

import ru.dorogov.education.Student;
import ru.dorogov.geometry.Line;
import ru.dorogov.geometry.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


    class Combo implements Kick<KarateBoy> {
        List<Kick<KarateBoy>> list = new ArrayList<>();

        public void make(KarateBoy kb) {
            for (Kick<KarateBoy> c : list) {
                c.make(kb);
            }
        }
    }

    class Punch implements Kick<KarateBoy> {
        @Override
        public void make(KarateBoy karateBoy) {
            karateBoy.punch();
        }
    }



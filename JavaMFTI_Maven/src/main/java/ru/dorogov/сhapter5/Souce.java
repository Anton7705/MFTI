package ru.dorogov.сhapter5;

public class Souce implements Comparable<Souce> {
    String name;
    Hotness hotness;

    @Override
    public int compareTo(Souce o) {
        return hotness.compareTo(hotness);
    }

}




package ru.dorogov.transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//1.6.10
public class Road {
    City destination;
    int cost;

    public Road(City destination, int cost) {
        this.setDestination(destination);
        this.cost = cost;
    }

    public void setDestination(City destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Дорога не может никуда не вести");
        }
        this.destination = destination;
    }

    public City getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return destination.getName() + " : " + cost;
    }


    @Override
    public final boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Road road)) return false;
        return destination == road.destination;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(destination);
    }
}

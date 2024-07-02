package ru.dorogov.transport;

//1.6.10
public class Road {
    private City destination;
    private int cost;

    Road(City destination, int cost) {
        this.destination = destination;
        this.cost = cost;
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
}

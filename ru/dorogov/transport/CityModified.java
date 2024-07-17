package ru.dorogov.transport;

public class CityModified extends City {
    public CityModified(String name) {
        super(name);
    }

    @Override
    public CityModified addRoad(Road r1) {
        super.addRoad(r1);
        r1.getDestination().roads.add(new Road(this, r1.cost));
        return this;
    }

    @Override
    public City removeRoad(City c1) {
        super.removeRoad(c1);
        c1.roads.remove(new Road(this, 0));
        return this;
    }
}

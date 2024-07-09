package ru.dorogov.transport;

public class CityModified extends City {
    public CityModified(String name) {
        super(name);
    }

    @Override
    public CityModified addRoad(Road r1) {
        if (this == r1.getDestination()) return this;
        for (Road road : roads) {
            if (road.getDestination() == r1.getDestination()) {
                road.setCost(r1.getCost());
                return this;
            }
        }
        roads.add(r1);
        r1.getDestination().roads.add(new Road(this, r1.cost));
        return this;
    }

    @Override
    public City removeRoad(City c1) {
        for (Road road : roads) {
            if (road.getDestination() == c1) {
                roads.remove(road);
                break;
            }
        }
        c1.roads.remove(new Road(this, 0));
        return this;
    }
}

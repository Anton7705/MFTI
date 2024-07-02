package ru.dorogov.transport;// 1.6.10

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Road> roads = new ArrayList<Road>();
    ;

    City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Road> getRoads() {
        return new ArrayList<>(roads);
    }

    public City addRoad(Road r1) {
        for (Road road : roads) {
            if (road.getDestination() == r1.getDestination()) {
                road.setCost(r1.getCost());
                return this;
            }
        }
        roads.add(r1);
        return this;
    }

    public City removeRoad(City c1) {
        for (Road road : roads) {
            if (road.getDestination() == c1) {
                roads.remove(road);
                break;
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "Город " + name + ", пути назначения и стоимость " + roads;
    }
}

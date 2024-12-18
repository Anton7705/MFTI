package ru.dorogov.transport;// 1.6.10

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    String name;
    List<Road> roads = new ArrayList<Road>();

    public City(String name) {
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
        if (this == r1.getDestination()) return this;
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

    @Override
    public final boolean equals(Object object) {
        if (roads.isEmpty()) return false;
        if (this == object) return true;
        if (!(object instanceof City city)) return false;

        List<Road> thisRoads = this.getRoads();
        List<Road> otherRoads = city.getRoads();

        if (thisRoads.size() != otherRoads.size()) return false;

        for (Road road : thisRoads) {
            if (!otherRoads.contains(road)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public final int hashCode() {
        return Objects.hash(roads);
    }
}

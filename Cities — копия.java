// 1.6.10

import java.util.ArrayList;

public class Cities {
    private String name;
    private ArrayList<Road2> arr1;

    Cities(String name) {
        this.name = name;
        arr1 = new ArrayList<Road2>();
    }

    public ArrayList<Road2> addRoad(Road2 r1) {
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i).getDestination().equals(r1.getDestination())) {
                throw new IllegalArgumentException("Уже есть такой путь");
            }

        }
        arr1.add(r1);
        return arr1;
    }

    public ArrayList<Road2> removeRoad(Road2 r1) {
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i).getDestination().equals(r1.getDestination())) {
                arr1.remove(i);
                return arr1;
            }
        }
        throw new IllegalArgumentException("Нет такого пути");
    }

    @Override
    public String toString() {
        return "Город " + name + ", пути назначения и стоимость " + arr1;
    }
}



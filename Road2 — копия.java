//1.6.10
public class Road2 {
    private String destination;
    private int cost;

    Road2(String destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public String getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return destination + " : " + cost;
    }
}

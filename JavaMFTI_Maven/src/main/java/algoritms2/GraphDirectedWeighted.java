package algoritms2;

import java.util.*;

public class GraphDirectedWeighted {
    final int[][] edge;

    public GraphDirectedWeighted(int x) {
        if (x < 0) {
            throw new RuntimeException("Количество вершин в графе не может быть отрицательным");
        }
        edge = new int[x][x];
        for (int i = 0; i < x; i++) {
            Arrays.fill(edge[i], -1);
        }
    }

    public void addEdge(int from, int to, int weight) {
        if (weight < 0) {
            throw new RuntimeException("В графе могут быть только неотрицательные ребра");
        }
        edge[from][to] = weight;
    }

    public boolean findEdge(int from, int to) {
        if (from < 0 || to < 0 || from >= edge.length || to >= edge.length) {
            return false;
        }
        return edge[from][to] != -1;
    }

    public int findWeight(int from, int to) {
        if (findEdge(from, to)) {
            return edge[from][to];
        }
        return -1;
    }

    public void removeEdge(int from, int to) {
        edge[from][to] = -1;
    }

    public List<Integer> getChildren(int v) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < edge.length; i++) {
            if (edge[v][i] != -1) {
                list.add(i);
            }
        }
        return list;
    }
}

class Starter12 {
    public static int dijkstra(GraphDirectedWeighted graph, int start, int end) {
        int n = graph.edge.length;
        int[] dist = new int[n];
        boolean[] used = new boolean[n];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && dist[j] != -1 && (v == -1 || dist[j] < dist[v])) {
                    v = j;
                }
            }
            if (v == -1 || dist[v] == -1) {
                break;
            }
            used[v] = true;
            for (int neighbor : graph.getChildren(v)) {
                int weight = graph.findWeight(v, neighbor);
                if (weight != -1) {
                    int newDist = dist[v] + weight;
                    if (dist[neighbor] == -1 || newDist < dist[neighbor]) {
                        dist[neighbor] = newDist;
                    }
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt() - 1;
        int f = scanner.nextInt() - 1;

        GraphDirectedWeighted graph = new GraphDirectedWeighted(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int weight = scanner.nextInt();
                if (weight != -1) {
                    graph.addEdge(i, j, weight);
                }
            }
        }
        int result = dijkstra(graph, s, f);
        System.out.println(result);
        scanner.close();
    }
}

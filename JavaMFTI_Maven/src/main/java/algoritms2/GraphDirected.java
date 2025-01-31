package algoritms2;

import java.util.*;

public class GraphDirected {
    final int[][] edge;

    public GraphDirected(int x) {
        edge = new int[x][x];
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    private void addEdge(int from, int to, int weight) {
        edge[from][to] = weight;
    }

    public boolean findEdge(int from, int to) {
        return edge[from][to] != 0;
    }

    public void removeEdge(int from, int to) {
        edge[from][to] = 0;
    }

    public List<Integer> getChildren(int v) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < edge.length; i++) {
            if (edge[v][i] != 0) {
                list.add(i);
            }
        }
        return list;
    }
}

class Starter11 {
    static int[] dist;

    private static int[] bfs(GraphDirected graph, int v) {
        Queue<Integer> vertexes = new ArrayDeque<>();
        vertexes.offer(v);
        dist[v] = 0;
        while (!vertexes.isEmpty()) {
            v = vertexes.poll();
            List<Integer> ch = graph.getChildren(v);
            for (Integer child : ch) {
                if (dist[child] == -1) {
                    dist[child] = dist[v] + 1;
                    vertexes.offer(child);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int x = scanner.nextInt() - 1;
        GraphDirected graph = new GraphDirected(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int y = scanner.nextInt();
                if (y == 1) {
                    graph.addEdge(i, j);
                }
            }
        }
        dist = new int[N];
        Arrays.fill(dist, -1);
        for (int ints : bfs(graph, x)) {
            System.out.print(ints + " ");
        }
        scanner.close();
    }
}
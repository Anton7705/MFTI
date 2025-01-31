package algoritms2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphUndirected {
    final int[][] edge;

    public GraphUndirected(int x) {
        if (x < 0) {
            throw new RuntimeException("Количество вершин в графе не может быть отрицательным");
        }
        edge = new int[x][x];
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    private void addEdge(int from, int to, int weight) {
        edge[from][to] = weight;
        edge[to][from] = weight;
    }

    public boolean findEdge(int from, int to) {
        return edge[from][to] != 0;
    }

    public void removeEdge(int from, int to) {
        edge[from][to] = 0;
        edge[to][from] = 0;
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

class Starter10 {
    static boolean[] visited;

    public static void dfs(GraphUndirected graph, int v) {
        visited[v] = true;
        List<Integer> children = graph.getChildren(v);
        for (int i = 0; i < children.size(); i++) {
            if (!visited[children.get(i)]) {
                dfs(graph, children.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        GraphUndirected graph = new GraphUndirected(N);
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.addEdge(x, y);
        }

        int componentCount = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(graph, i);
                componentCount++;
            }
        }
        System.out.println(componentCount);
        scanner.close();
    }
}
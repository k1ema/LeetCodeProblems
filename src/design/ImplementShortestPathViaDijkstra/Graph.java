package design.ImplementShortestPathViaDijkstra;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V;
    private List<Edge>[] adjList;

    Graph(int V) {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public int getV() {
        return V;
    }

    void addEdge(Edge e) {
        adjList[e.from()].add(e);
        adjList[e.to()].add(new Edge(e.to(), e.from(), e.weight()));
    }

    Iterable<Edge> adj(int v) {
        return adjList[v];
    }
}

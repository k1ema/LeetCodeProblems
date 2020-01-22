package design.ImplementFordFulkerson;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class FlowNetwork {
    private final List<FlowEdge>[] adj;

    private final int V;
    private int E;

    FlowNetwork(int V) {
        this.V = V;
        adj = new List[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    int V() {
        return V;
    }

    int E() {
        return E;
    }

    Iterable<FlowEdge> adj(int vertex) {
        return adj[vertex];
    }

    void addEdge(FlowEdge edge) {
        adj[edge.from()].add(edge);
        adj[edge.to()].add(edge);
        E++;
    }

    @Override
    public String toString() {
        return String.format("%s", Arrays.toString(adj));
    }
}

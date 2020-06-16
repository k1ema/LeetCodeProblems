package design.ImplementShortestPathViaDijkstra;

public class Edge {
    private int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    int from() {
        return u;
    }

    int to() {
        return v;
    }

    int weight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("[%d-%d %d]", u, v, weight);
    }
}

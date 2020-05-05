package design.ImplementShortestPathViaDijkstra;

public class Edge {
    private int v, w, weight;

    Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    int from() {
        return v;
    }

    int to() {
        return w;
    }

    int weight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("[%d-%d %d]", v, w, weight);
    }
}

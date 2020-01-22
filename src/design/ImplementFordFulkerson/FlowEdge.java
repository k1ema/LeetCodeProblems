package design.ImplementFordFulkerson;

class FlowEdge {
    private final int v, w;
    private final double capacity;
    private double flow;

    FlowEdge(int v, int w, double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    int from() {
        return v;
    }

    int to() {
        return w;
    }

    double flow() {
        return flow;
    }

    double capacity() {
        return capacity;
    }

    int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new IllegalArgumentException("Illegal vertex: " + vertex);
        }
    }

    double residualCapacityTo(int vertex) {
        if (vertex == v) {
            return flow;
        } else if (vertex == w) {
            return capacity - flow;
        } else {
            throw new IllegalArgumentException("Illegal vertex: " + vertex);
        }
    }

    void addResidualFlowTo(int vertex, double delta) {
        double residualCapacity = residualCapacityTo(vertex);
        if (delta > residualCapacity) {
            throw new IllegalArgumentException(String.format("Delta is bigger than possible value: %f > %f",
                    delta, residualCapacity));
        }
        if (vertex == v) {
            flow -= delta;
        } else if (vertex == w) {
            flow += delta;
        } else {
            throw new IllegalArgumentException("Invalid vertex: " + vertex);
        }
    }

    @Override
    public String toString() {
        return String.format("%d->%d %f:%f", v, w, flow, capacity);
    }
}

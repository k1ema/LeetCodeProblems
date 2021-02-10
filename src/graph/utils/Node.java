package graph.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return val == node.val &&
                Objects.equals(neighbors, node.neighbors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, neighbors);
    }
}

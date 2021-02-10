package design.ImplementFordFulkerson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FFTest {
    @Test
    public void test() {
        FlowNetwork G = new FlowNetwork(6);
        G.addEdge(new FlowEdge(0, 1, 2));
        G.addEdge(new FlowEdge(0, 2, 3));
        G.addEdge(new FlowEdge(1, 3, 3));
        G.addEdge(new FlowEdge(1, 4, 1));
        G.addEdge(new FlowEdge(2, 3, 1));
        G.addEdge(new FlowEdge(2, 4, 1));
        G.addEdge(new FlowEdge(3, 5, 2));
        G.addEdge(new FlowEdge(4, 5, 3));
        FF ff = new FF(G, 0, 5);
        assertEquals(4, ff.getValue(), 0.001);
    }
}

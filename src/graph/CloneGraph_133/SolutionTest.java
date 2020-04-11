package graph.CloneGraph_133;

import java.util.Arrays;

import graph.utils.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node3.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node4.neighbors = Arrays.asList(node1, node3);
        Node cloned = s.cloneGraph(node1);
        assertEquals(node1, cloned);
    }
}

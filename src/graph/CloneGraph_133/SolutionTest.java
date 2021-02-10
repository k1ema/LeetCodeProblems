package graph.CloneGraph_133;

import graph.utils.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        testNodes(node1, cloned);
        testNodes(node2, cloned.neighbors.get(0));
        testNodes(node4, cloned.neighbors.get(1));
        testNodes(node3, cloned.neighbors.get(0).neighbors.get(1));
    }

    private void testNodes(Node expected, Node actual) {
        assertEquals(expected.val, actual.val);
        assertEquals(expected.neighbors.size(), actual.neighbors.size());
        for (int i = 0; i < actual.neighbors.size(); i++) {
            Node nei = actual.neighbors.get(i);
            assertEquals(expected.neighbors.get(i).val, nei.val);
        }
    }
}

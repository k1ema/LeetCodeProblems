package tree.PopulatingNextRightPointersInEachNode_116;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();

        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);

        Node e7 = new Node(7, null, null, null);
        Node e6 = new Node(6, null, null, e7);
        Node e5 = new Node(5, null, null, e6);
        Node e4 = new Node(4, null, null, e5);
        Node e3 = new Node(3, e6, e7, null);
        Node e2 = new Node(2, e4, e5, e3);
        Node e1 = new Node(1, e2, e3, null);

        assertEquals(e1, s.connect(node1));
    }
}

package tree.InorderSuccessorInBST_II_510;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Solution.Node node = new Solution.Node(2);
        node.left = new Solution.Node(1);
        node.left.parent = node;
        node.right = new Solution.Node(3);
        node.right.parent = node;
        assertEquals(node.val, s.inorderSuccessor(node.left).val);
    }
}
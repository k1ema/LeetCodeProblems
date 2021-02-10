package tree.MergeTwoBinaryTrees_617;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;
import tree.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode t1 = Parser.stringToTreeNode("[1, 3, 2, 5, null, null, null]");
        TreeNode t2 = Parser.stringToTreeNode("[2, 1, 3, null, 4, null, 7]");
        TreeNode tree = s.mergeTrees(t1, t2);
        String result = Parser.treeNodeToString(tree);
        System.out.println(result);
        assertEquals("[3, 4, 5, 5, 4, null, 7, null, null, null, null, null, null]", result);
    }
}

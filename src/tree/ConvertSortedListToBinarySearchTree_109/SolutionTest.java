package tree.ConvertSortedListToBinarySearchTree_109;

import linkedList.utils.ListNode;
import org.junit.Test;
import tree.utils.Parser;
import tree.utils.TreeNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode inputTree = s.sortedListToBST(linkedList.utils.Parser.stringToListNode("[-10,-3,0,5,9]"));
        assertEquals(Parser.stringToTreeNode("[0,-3,9,-10,null,5]"), inputTree);
        assertEquals(new TreeNode(0), s.sortedListToBST(new ListNode(0)));
        assertNull(s.sortedListToBST(null));

        inputTree = s.sortedListToBST1(linkedList.utils.Parser.stringToListNode("[-10,-3,0,5,9]"));
        assertEquals(Parser.stringToTreeNode("[0,-10,5,null,-3,null,9]"), inputTree);
    }
}

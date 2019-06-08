package tree.ConvertSortedArrayToBinarySearchTree_108;

import org.junit.Test;

import tree.utils.Parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Parser.stringToTreeNode("[0,-3,9,-10,null,5]"), s.sortedArrayToBST(new int[] {-10, -3, 0, 5, 9}));
        assertNull(s.sortedArrayToBST(new int[] {}));
        assertNull(s.sortedArrayToBST(null));
    }
}

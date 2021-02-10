package dynamic.UniqueBinarySearchTrees_96;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.numTrees(0));
        assertEquals(1, s.numTrees(1));
        assertEquals(5, s.numTrees(3));
        assertEquals(14, s.numTrees(4));
        assertEquals(42, s.numTrees(5));
        assertEquals(4862, s.numTrees(9));
        assertEquals(16796, s.numTrees(10));
        assertEquals(16796, s.numTrees(10));
        assertEquals(1767263190, s.numTrees(19));
    }
}

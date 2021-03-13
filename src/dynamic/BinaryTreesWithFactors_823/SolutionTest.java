package dynamic.BinaryTreesWithFactors_823;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.numFactoredBinaryTrees(new int[] {2, 4}));
        assertEquals(7, s.numFactoredBinaryTrees(new int[] {2, 4, 5, 10}));
        assertEquals(8, s.numFactoredBinaryTrees(new int[] {2, 4, 8}));
    }
}
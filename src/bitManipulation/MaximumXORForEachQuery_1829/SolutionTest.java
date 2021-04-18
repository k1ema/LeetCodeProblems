package bitManipulation.MaximumXORForEachQuery_1829;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {0, 3, 2, 3}, s.getMaximumXor(new int[] {0, 1, 1, 3}, 2));
        assertArrayEquals(new int[] {5, 2, 6, 5}, s.getMaximumXor(new int[] {2, 3, 4, 7}, 3));
        assertArrayEquals(new int[] {4, 3, 6, 4, 6, 7}, s.getMaximumXor(new int[] {0, 1, 2, 2, 5, 7}, 3));
    }
}
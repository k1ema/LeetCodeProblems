package dynamic.MaxDotProductOfTwoSubsequences_1458;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(18, s.maxDotProduct(new int[] {2, 1, -2, 5}, new int[] {3, 0, -6}));
        assertEquals(21, s.maxDotProduct(new int[] {3, -2}, new int[] {2, -6, 7}));
        assertEquals(-1, s.maxDotProduct(new int[] {-1, -1}, new int[] {1, 1}));
        assertEquals(-3, s.maxDotProduct(new int[] {-5, -1, -2}, new int[] {3, 3, 5, 5}));
    }
}
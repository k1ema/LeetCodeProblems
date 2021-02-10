package dynamic.KConcatenationMaximumSum_1191;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(9, s.kConcatenationMaxSum(new int[] {1, 2}, 3));
        assertEquals(2, s.kConcatenationMaxSum(new int[] {1, -2, 1}, 5));
        assertEquals(0, s.kConcatenationMaxSum(new int[] {-1, -2}, 7));
        assertEquals(0, s.kConcatenationMaxSum(new int[] {-1, -2}, 1));
        assertEquals(20, s.kConcatenationMaxSum(new int[] {-5, -2, 0, 0, 3, 9, -2, -5, 4}, 5));
        assertEquals(16, s.kConcatenationMaxSum(new int[] {5, 2, -10, 2, 4}, 3));
    }
}
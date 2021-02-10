package dynamic.LongestIncreasingSubsequence_300;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, s.lengthOfLIS(new int[] {1, 2, 3, 1, 1, 1, 4}));
        assertEquals(4, s.lengthOfLIS(new int[] {1, 2, 3, 1, 2, 1, 4}));
        assertEquals(3, s.lengthOfLIS(new int[] {10, 2, 3, 1, 2, 1, 2, 4}));
    }
}
package dynamic.NumberOfLongestIncreasingSubsequence_673;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findNumberOfLIS(new int[] {1, 3, 5, 4, 7}));
        assertEquals(5, s.findNumberOfLIS(new int[] {2, 2, 2, 2, 2}));
    }
}
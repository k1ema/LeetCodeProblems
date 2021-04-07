package binarySearch.RussianDollEnvelopes_354;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.maxEnvelopes(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        assertEquals(1, s.maxEnvelopes(new int[][] {{1, 1}, {1, 1}, {1, 1}}));
    }
}
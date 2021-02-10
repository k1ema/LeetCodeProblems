package dynamic.LongestArithmeticSequence_1027;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.longestArithSeqLength(new int[] {3, 6, 9, 12}));
        assertEquals(3, s.longestArithSeqLength(new int[] {9, 4, 7, 2, 10}));
        assertEquals(4, s.longestArithSeqLength(new int[] {20, 1, 15, 3, 10, 5, 8}));
    }
}
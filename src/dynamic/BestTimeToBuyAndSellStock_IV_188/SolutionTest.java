package dynamic.BestTimeToBuyAndSellStock_IV_188;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.maxProfit(2, new int[] {2, 4, 1}));
        assertEquals(7, s.maxProfit(2, new int[] {3, 2, 6, 5, 0, 3}));
        assertEquals(11, s.maxProfit(2, new int[] {0, 4, 2, 7, 2, 6}));
        assertEquals(0, s.maxProfit(0, new int[] {1, 3}));
    }
}
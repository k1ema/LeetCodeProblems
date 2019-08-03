package array.BestTimeToBuyAndSellStock_121;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        assertEquals(0, s.maxProfit(new int[] {7, 6, 4, 3, 1}));
        assertEquals(18, s.maxProfit(new int[] {2, 20, 1, 5, 3, 17, 4}));
        assertEquals(1, s.maxProfit(new int[] {1, 2}));
        assertEquals(0, s.maxProfit(new int[] {3, 3}));
    }
}

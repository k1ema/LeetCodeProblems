package array.BestTimeToBuyAndSellStock_II_122;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        assertEquals(4, s.maxProfit(new int[] {1, 2, 3, 4, 5}));
        assertEquals(0, s.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }
}
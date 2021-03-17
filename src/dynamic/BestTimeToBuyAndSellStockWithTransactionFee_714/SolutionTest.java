package dynamic.BestTimeToBuyAndSellStockWithTransactionFee_714;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(8, s.maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
        assertEquals(6, s.maxProfit(new int[] {1, 3, 7, 5, 10, 3}, 3));
    }
}
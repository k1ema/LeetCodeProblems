package dynamic.CoinChange_322;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.coinChange(new int[] {1, 2, 5}, 11));
        assertEquals(3, s.coinChange(new int[] {2, 3}, 7));
        assertEquals(4, s.coinChange(new int[] {2, 3}, 10));
    }
}

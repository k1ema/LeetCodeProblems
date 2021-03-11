package dynamic.CoinChange_322;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.coinChange(new int[] {1, 2, 5}, 11));
        assertEquals(-1, s.coinChange(new int[] {2}, 3));
        assertEquals(0, s.coinChange(new int[] {1}, 0));
        assertEquals(1, s.coinChange(new int[] {1}, 1));
        assertEquals(2, s.coinChange(new int[] {1}, 2));
        assertEquals(3, s.coinChange(new int[] {2, 3}, 7));
        assertEquals(4, s.coinChange(new int[] {2, 3}, 10));
        assertEquals(20, s.coinChange(new int[] {186, 419, 83, 408}, 6249));
    }
}
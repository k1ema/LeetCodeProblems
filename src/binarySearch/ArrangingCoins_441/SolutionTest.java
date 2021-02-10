package binarySearch.ArrangingCoins_441;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.arrangeCoins(1));
        assertEquals(2, s.arrangeCoins(5));
        assertEquals(3, s.arrangeCoins(8));
        assertEquals(49683, s.arrangeCoins(1234242342));
    }
}
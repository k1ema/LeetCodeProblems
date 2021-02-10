package array.MaximumProductOfThreeNumbers_628;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.maximumProduct(new int[] {1, 2, 3}));
        assertEquals(24, s.maximumProduct(new int[] {1, 2, 3, 4}));
        assertEquals(-6, s.maximumProduct(new int[] {-1, -2, -3, -4}));
        assertEquals(50, s.maximumProduct(new int[] {-1, 4, 2, -10, 5}));
        assertEquals(-6, s.maximumProduct(new int[] {-1, -2, -3}));
        assertEquals(0, s.maximumProduct(new int[] {1, 0, 100}));
    }
}
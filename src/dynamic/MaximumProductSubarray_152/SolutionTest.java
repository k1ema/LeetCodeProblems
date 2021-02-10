package dynamic.MaximumProductSubarray_152;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.maxProduct(new int[] {2, 3, -2, 4}));
        assertEquals(0, s.maxProduct(new int[] {-2, 0, -1}));
        assertEquals(24, s.maxProduct(new int[] {-2, 3, -4}));
        assertEquals(24, s.maxProduct(new int[] {2, -5, -2, -4, 3}));
        assertEquals(120, s.maxProduct(new int[] {-2, -5, -2, -4, -3}));
    }
}

package array.ProductOfArrayExceptSelf_238;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {24, 12, 8, 6}, s.productExceptSelf(new int[] {1, 2, 3, 4}));
        assertArrayEquals(new int[] {24, 56, 84, 42}, s.productExceptSelf(new int[] {7, 3, 2, 4}));
        assertArrayEquals(new int[] {1, 0}, s.productExceptSelf(new int[] {0, 1}));
    }
}
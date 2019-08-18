package dynamic.CountingBits_338;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {0}, s.countBits(0));
        assertArrayEquals(new int[] {0, 1, 1}, s.countBits(2));
        assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2}, s.countBits(5));
    }
}

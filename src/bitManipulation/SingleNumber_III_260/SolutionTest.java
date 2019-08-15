package bitManipulation.SingleNumber_III_260;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {3, 5}, s.singleNumber(new int[] {1, 2, 1, 3, 2, 5}));
    }
}

package bitManipulation.SingleNumber_II_137;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.singleNumber(new int[] {2, 2, 3, 2}));
        assertEquals(99, s.singleNumber(new int[] {0, 1, 0, 1, 0, 1, 99}));
    }
}

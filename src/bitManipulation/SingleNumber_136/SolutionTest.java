package bitManipulation.SingleNumber_136;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.singleNumber(new int[] {2, 2, 1}));
        assertEquals(4, s.singleNumber(new int[] {4, 2, 1, 2, 1}));
    }
}

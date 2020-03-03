package dynamic.HouseRobber_198;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.rob(new int[] {1, 2, 3, 1}));
        assertEquals(12, s.rob(new int[] {2, 7, 9, 3, 1}));
        assertEquals(17, s.rob(new int[] {2, 7, 9, 3, 1, 6, 4}));
    }
}
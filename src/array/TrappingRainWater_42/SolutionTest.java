package array.TrappingRainWater_42;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(4, s.trap(new int[] {3, 2, 1, 0, 2, 1, 0, 1}));
        assertEquals(0, s.trap(new int[] {}));
    }
}
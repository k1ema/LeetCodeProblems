package dynamic.HouseRobber_II_213;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.rob(new int[] {2, 3, 2}));
        assertEquals(4, s.rob(new int[] {1, 2, 3, 1}));
        assertEquals(0, s.rob(new int[] {0}));
        assertEquals(1, s.rob(new int[] {1}));
        assertEquals(3, s.rob(new int[] {2, 3}));
        assertEquals(340, s.rob(new int[] {200, 3, 140, 20, 10}));
        assertEquals(3, s.rob(new int[] {1, 1, 1, 2}));
    }
}
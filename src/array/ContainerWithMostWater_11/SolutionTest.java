package array.ContainerWithMostWater_11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(49, s.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(24, s.maxArea(new int[] {1, 3, 2, 5, 25, 24, 5}));
        assertEquals(17, s.maxArea(new int[] {2, 3, 4, 5, 18, 17, 6}));
        assertEquals(42, s.maxArea(new int[] {4, 6, 4, 4, 6, 2, 6, 7, 11, 2}));
    }
}

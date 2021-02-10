package array.MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts_1465;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.maxArea(5, 4, new int[] {1, 2, 4}, new int[] {1, 3}));
        assertEquals(6, s.maxArea(5, 4, new int[] {3, 1}, new int[] {1}));
        assertEquals(9, s.maxArea(5, 4, new int[] {3}, new int[] {3}));
    }
}
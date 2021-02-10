package array.ThirdMaximumNumber_414;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.thirdMax(new int[] {3, 2, 1}));
        assertEquals(2, s.thirdMax(new int[] {1, 2}));
        assertEquals(1, s.thirdMax(new int[] {2, 2, 3, 1}));
        assertEquals(-2, s.thirdMax(new int[] {-2, -1, -1, 0}));
        assertEquals(-2147483648, s.thirdMax(new int[] {1, 2, -2147483648}));
    }
}

package array.FirstMissingPositive_41;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.firstMissingPositive(new int[] {}));
        assertEquals(2, s.firstMissingPositive(new int[] {1}));
        assertEquals(1, s.firstMissingPositive(new int[] {-1}));
        assertEquals(1, s.firstMissingPositive(new int[] {0}));
        assertEquals(1, s.firstMissingPositive(new int[] {-1, -2, -3}));
        assertEquals(3, s.firstMissingPositive(new int[] {1, 2, 0}));
        assertEquals(2, s.firstMissingPositive(new int[] {3, 4, -1, 1}));
        assertEquals(1, s.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
        assertEquals(1, s.firstMissingPositive(new int[] {Integer.MAX_VALUE}));
        assertEquals(1, s.firstMissingPositive(new int[] {Integer.MIN_VALUE}));
        assertEquals(1, s.firstMissingPositive(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));
        assertEquals(2, s.firstMissingPositive(new int[] {0, 1, Integer.MIN_VALUE, Integer.MAX_VALUE}));
        assertEquals(6, s.firstMissingPositive(new int[] {1, 2, 3, 4, 5}));
        assertEquals(6, s.firstMissingPositive(new int[] {1, 2, 3, 4, 5, 7, 8, 9}));
    }
}
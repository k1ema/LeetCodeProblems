package array.PlusOne_66;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 2, 4}, s.plusOne(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {4, 3, 2, 2}, s.plusOne(new int[] {4, 3, 2, 1}));
        assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                s.plusOne(new int[] {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}));
    }
}

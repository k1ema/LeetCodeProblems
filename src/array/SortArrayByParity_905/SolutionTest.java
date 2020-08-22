package array.SortArrayByParity_905;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {4, 2, 1, 3}, s.sortArrayByParity(new int[] {3, 1, 2, 4}));
        assertArrayEquals(new int[] {4, 2, 9, 1, 11, 3}, s.sortArrayByParity(new int[] {3, 1, 9, 2, 11, 4}));
        assertArrayEquals(new int[] {0, 2}, s.sortArrayByParity(new int[] {0, 2}));
    }
}
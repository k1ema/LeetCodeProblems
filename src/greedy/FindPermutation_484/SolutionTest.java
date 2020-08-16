package greedy.FindPermutation_484;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 2}, s.findPermutation("I"));
        assertArrayEquals(new int[] {2, 1, 3}, s.findPermutation("DI"));
        assertArrayEquals(new int[] {3, 2, 1, 4, 6, 5, 8, 7, 9, 11, 10}, s.findPermutation("DDIIDIDIID"));
    }
}
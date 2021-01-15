package slidingWindow.MaximumPointsYouCanObtainFromCards_1423;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(12, s.maxScore(new int[] {1, 2, 3, 4, 5, 6, 1}, 3));
        assertEquals(4, s.maxScore(new int[] {2, 2, 2}, 2));
        assertEquals(55, s.maxScore(new int[] {9, 7, 7, 9, 7, 7, 9}, 7));
        assertEquals(1, s.maxScore(new int[] {1, 1000, 1}, 1));
        assertEquals(202, s.maxScore(new int[] {1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }
}
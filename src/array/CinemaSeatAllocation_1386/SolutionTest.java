package array.CinemaSeatAllocation_1386;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.maxNumberOfFamilies(3,
                new int[][] {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}));
        assertEquals(2, s.maxNumberOfFamilies(2,
                new int[][] {{2, 1}, {1, 8}, {2, 6}}));
        assertEquals(4, s.maxNumberOfFamilies(4,
                new int[][] {{4, 3}, {1, 4}, {4, 6}, {1, 7}}));
    }
}
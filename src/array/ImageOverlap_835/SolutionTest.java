package array.ImageOverlap_835;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.largestOverlap(new int[][] {
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0}},
                new int[][] {
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 0, 1}}
        ));

        assertEquals(4, s.largestOverlap(new int[][] {
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 1, 1}},
                new int[][] {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 0}}
        ));

            assertEquals(3, s.largestOverlap(new int[][] {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 1, 1}},
                new int[][] {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 0}}
        ));

        assertEquals(5, s.largestOverlap(new int[][] {
                        {0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 1}},
                new int[][] {
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1},
                        {1, 0, 1, 1, 1}}
        ));
    }
}
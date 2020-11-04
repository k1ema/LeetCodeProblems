package hashtable.NumberOfDistinct_Islands_II_711;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.numDistinctIslands2(new int[][] {
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1}
        }));

        assertEquals(2, s.numDistinctIslands2(new int[][] {
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        }));

        assertEquals(1, s.numDistinctIslands2(new int[][] {
                {0, 0, 1},
                {0, 0, 1},
                {1, 1, 0},
        }));
    }
}
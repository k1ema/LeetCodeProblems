package dynamic.MinimumCostForTickets_983;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(11, s.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}));
        assertEquals(17, s.mincostTickets(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[] {2, 7, 15}));
    }
}
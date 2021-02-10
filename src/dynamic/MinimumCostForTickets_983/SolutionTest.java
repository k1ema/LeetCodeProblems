package dynamic.MinimumCostForTickets_983;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.mincostTickets(new int[] {1, 10, 30}, new int[] {2, 3, 5}));
        assertEquals(11, s.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}));
        assertEquals(17, s.mincostTickets(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[] {2, 7, 15}));
        assertEquals(423, s.mincostTickets(new int[] {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 24, 25, 27, 28, 29, 30, 31, 34, 37, 38, 39, 41, 43, 44, 45, 47, 48, 49, 54, 57, 60, 62, 63, 66, 69, 70, 72, 74, 76, 78, 80, 81, 82, 83, 84, 85, 88, 89, 91, 93, 94, 97, 99},
                new int[] {9, 38, 134}));
    }
}

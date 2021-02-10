package unionFind.MostStonesRemovedWithSameRowOrColumn_947;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.removeStones(new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        assertEquals(3, s.removeStones(new int[][] {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
        assertEquals(0, s.removeStones(new int[][] {{0, 0}}));
    }
}

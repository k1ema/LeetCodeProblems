package math.MinimumCostToMoveChipsToTheSamePosition_1217;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.minCostToMoveChips(new int[] {1, 2, 3}));
        assertEquals(2, s.minCostToMoveChips(new int[] {2, 2, 2, 3, 3}));
        assertEquals(1, s.minCostToMoveChips(new int[] {1, 1000000000}));
    }
}
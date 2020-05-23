package dynamic.NumberOfDiceRollsWithTargetSum_1155;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.numRollsToTarget(1, 6, 3));
        assertEquals(6, s.numRollsToTarget(2, 6, 7));
        assertEquals(1, s.numRollsToTarget(2, 5, 10));
        assertEquals(0, s.numRollsToTarget(1, 2, 3));
        assertEquals(222616187, s.numRollsToTarget(30, 30, 500));
    }
}
package greedy.GasStation_134;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
        assertEquals(-1, s.canCompleteCircuit(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
        assertEquals(3, s.canCompleteCircuit(new int[] {5, 8, 2, 8}, new int[] {6, 5, 6, 6}));
        assertEquals(-1, s.canCompleteCircuit(new int[] {4, 5, 2, 6, 5, 3}, new int[] {3, 2, 7, 3, 2, 9}));
    }
}
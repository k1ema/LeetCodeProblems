package array.BulbSwitcher_III_1375;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.numTimesAllBlue(new int[] {2, 1, 3, 5, 4}));
        assertEquals(2, s.numTimesAllBlue(new int[] {3, 2, 4, 1, 5}));
        assertEquals(1, s.numTimesAllBlue(new int[] {4, 1, 2, 3}));
        assertEquals(3, s.numTimesAllBlue(new int[] {2, 1, 4, 3, 6, 5}));
        assertEquals(6, s.numTimesAllBlue(new int[] {1, 2, 3, 4, 5, 6}));
    }
}
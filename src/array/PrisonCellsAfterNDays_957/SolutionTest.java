package array.PrisonCellsAfterNDays_957;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {0, 0, 1, 1, 0, 0, 0, 0},
                s.prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 7));
        assertArrayEquals(new int[] {0, 0, 1, 1, 1, 1, 1, 0},
                s.prisonAfterNDays(new int[] {1, 0, 0, 1, 0, 0, 1, 0}, 1000000000));
    }
}
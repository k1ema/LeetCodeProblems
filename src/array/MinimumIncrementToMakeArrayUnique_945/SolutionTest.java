package array.MinimumIncrementToMakeArrayUnique_945;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.minIncrementForUnique(new int[] {1, 2, 2}));
        assertEquals(6, s.minIncrementForUnique(new int[] {3, 2, 1, 2, 1, 7}));
        assertEquals(5, s.minIncrementForUnique(new int[] {2, 1, 1, 1}));
    }
}
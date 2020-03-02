package array.MinimumDominoRotationsForEqualRow_1007;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.minDominoRotations(new int[] {2, 1, 2, 4, 2, 2}, new int[] {5, 2, 6, 2, 3, 2}));
        assertEquals(-1, s.minDominoRotations(new int[] {3, 5, 1, 2, 3}, new int[] {3, 6, 3, 3, 4}));
    }
}
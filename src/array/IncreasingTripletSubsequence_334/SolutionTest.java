package array.IncreasingTripletSubsequence_334;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.increasingTriplet(new int[] {1, 2, 3, 4, 5}));
        assertFalse(s.increasingTriplet(new int[] {5, 4, 3, 2, 1}));
        assertTrue(s.increasingTriplet(new int[] {2, 1, 5, 0, 4, 6}));
        assertFalse(s.increasingTriplet(new int[] {2, 1, 5, 0, 3}));
    }
}
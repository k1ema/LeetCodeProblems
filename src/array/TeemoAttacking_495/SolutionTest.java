package array.TeemoAttacking_495;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.findPoisonedDuration(new int[] {1, 4}, 2));
        assertEquals(3, s.findPoisonedDuration(new int[] {1, 2}, 2));
        assertEquals(5, s.findPoisonedDuration(new int[] {0, 1, 2, 3, 4}, 1));
    }
}
package stack.Pattern_132_456;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertFalse(s.find132pattern(new int[] {1, 2, 3, 4}));
        Assert.assertTrue(s.find132pattern(new int[] {3, 1, 4, 2}));
        Assert.assertTrue(s.find132pattern(new int[] {-1, 3, 2, 0}));
        Assert.assertTrue(s.find132pattern(new int[] {3, 5, 0, 3, 4}));
    }
}
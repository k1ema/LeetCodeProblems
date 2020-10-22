package stack.NextGreaterElement_I_496;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {-1, 3, -1}, s.nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2}));
        assertArrayEquals(new int[] {3, -1}, s.nextGreaterElement(new int[] {2, 4}, new int[] {1, 2, 3, 4}));
    }
}
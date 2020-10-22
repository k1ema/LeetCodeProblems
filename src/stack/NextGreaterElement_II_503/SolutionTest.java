package stack.NextGreaterElement_II_503;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, -1, 2}, s.nextGreaterElements(new int[] {1, 2, 1}));
        assertArrayEquals(new int[] {}, s.nextGreaterElements(new int[] {}));
        assertArrayEquals(new int[] {-1, 8, 8, 4, 8}, s.nextGreaterElements(new int[] {8, 6, 5, 3, 4}));
        assertArrayEquals(new int[] {10, 12, -1, 9, 10}, s.nextGreaterElements(new int[] {8, 10, 12, 3, 9}));
    }
}
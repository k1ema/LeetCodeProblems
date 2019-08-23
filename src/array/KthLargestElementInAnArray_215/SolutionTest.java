package array.KthLargestElementInAnArray_215;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, s.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        assertEquals(-1, s.findKthLargest(new int[] {-1, -1}, 2));
    }
}

package hashtable.SubarraySumEqualsK_560;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.subarraySum(new int[] {1, 1, 1}, 2));
        assertEquals(4, s.subarraySum(new int[] {1, 1, 1, 1, 1}, 2));
        assertEquals(3, s.subarraySum(new int[] {1, 10, -5, 7, 3, 2, 1}, 5));
        assertEquals(6, s.subarraySum(new int[] {3, 4, 7, 2, -3, 1, 4, 2, 1}, 7));
    }
}

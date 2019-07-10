package array.ThreeSumClosest_16;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}

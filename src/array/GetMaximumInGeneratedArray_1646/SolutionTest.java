package array.GetMaximumInGeneratedArray_1646;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.getMaximumGenerated(7));
        assertEquals(1, s.getMaximumGenerated(2));
        assertEquals(0, s.getMaximumGenerated(0));
        assertEquals(2, s.getMaximumGenerated(3));
        assertEquals(21, s.getMaximumGenerated(100));
    }
}
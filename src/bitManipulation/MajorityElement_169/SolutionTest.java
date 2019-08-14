package bitManipulation.MajorityElement_169;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.majorityElement(new int[] {3, 2, 3}));
        assertEquals(2, s.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
        assertEquals(1, s.majorityElement(new int[] {1, 1, 1, 2, 2, 4, 4, 1, 1}));
        assertEquals(Integer.MAX_VALUE, s.majorityElement(new int[] {Integer.MAX_VALUE}));
        assertEquals(Integer.MIN_VALUE, s.majorityElement(new int[] {Integer.MIN_VALUE}));
    }
}

package array.FindPeakElement_162;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findPeakElement(new int[] {1, 2, 3, 1}));

        int peekInd = s.findPeakElement(new int[] {1, 2, 1, 3, 5, 6, 4});
        assertTrue(peekInd == 1 || peekInd == 5);

        assertEquals(0, s.findPeakElement(new int[] {3, 2, 1}));
        assertEquals(2, s.findPeakElement(new int[] {1, 2, 3}));
        assertEquals(1, s.findPeakElement(new int[] {3, 4, 3, 2, 1}));
    }
}

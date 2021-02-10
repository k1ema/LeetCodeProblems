package hashtable.ContiguousArray_525;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findMaxLength(new int[] {0, 1}));
        assertEquals(2, s.findMaxLength(new int[] {0, 1, 0}));
        assertEquals(6, s.findMaxLength(new int[] {1, 0, 1, 1, 0, 1, 0, 1}));
    }
}
package unionFind.LongestConsecutiveSequence_128;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        assertEquals(0, s.longestConsecutive(new int[] {}));
        assertEquals(1, s.longestConsecutive(new int[] {0}));
        assertEquals(2, s.longestConsecutive(new int[] {0, -1}));
        assertEquals(3, s.longestConsecutive(new int[] {1, 2, 0, 1}));
        assertEquals(1, s.longestConsecutive(new int[] {1, 1, 1, 1}));
        assertEquals(2, s.longestConsecutive(new int[] {2, 1, 1, 1, 1}));
        assertEquals(2, s.longestConsecutive(new int[] {-1, -2}));
        assertEquals(7, s.longestConsecutive(new int[] {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        assertEquals(1, s.longestConsecutive(new int[] {2147483647, -2147483648}));
        assertEquals(12, s.longestConsecutive(new int[] {-4, -1, 4, -5, 1, -6, 9, -6, 0, 2, 2, 7, 0, 9, -3, 8, 9, -2, -6, 5, 0, 3, 4, -2}));
    }
}

package array.FindTheDuplicateNumber_287;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.findDuplicate(new int[] {3, 1, 3, 4, 2}));
        assertEquals(4, s.findDuplicate(new int[] {3, 2, 1, 4, 7, 6, 5, 4, 8}));
        assertEquals(9, s.findDuplicate(new int[] {2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }
}

package dynamic.AllocateMailboxes_1478;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.minDistance(new int[] {1, 4, 8, 10, 20}, 3));
        assertEquals(9, s.minDistance(new int[] {2, 3, 5, 12, 18}, 2));
        assertEquals(8, s.minDistance(new int[] {7, 4, 6, 1}, 1));
        assertEquals(0, s.minDistance(new int[] {3, 6, 14, 10}, 4));
        assertEquals(6, s.minDistance(new int[] {19, 28, 10, 30, 11, 6, 5, 17}, 4));
        assertEquals(2, s.minDistance(new int[] {5, 18, 25, 27, 28, 13, 9, 12, 22}, 7));
    }
}
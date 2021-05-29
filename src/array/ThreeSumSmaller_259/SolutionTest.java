package array.ThreeSumSmaller_259;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.threeSumSmaller(new int[] {-2, 0, 1, 3}, 2));
        assertEquals(0, s.threeSumSmaller(new int[] {}, 0));
        assertEquals(0, s.threeSumSmaller(new int[] {0}, 0));
        assertEquals(1282, s.threeSumSmaller(new int[] {-2, 0, 1, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 1, 3, 4, 5, 6, 4, 3, 2}, 14));
    }
}
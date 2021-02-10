package dynamic.NumbersWithSameConsecutiveDifferences_967;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {181, 292, 707, 818, 929}, s.numsSameConsecDiff(3, 7));
        assertArrayEquals(new int[] {10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98}, s.numsSameConsecDiff(2, 1));
        assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, s.numsSameConsecDiff(1, 0));
        assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, s.numsSameConsecDiff(1, 1));
        assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, s.numsSameConsecDiff(1, 3));
        assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, s.numsSameConsecDiff(1, 6));
        assertArrayEquals(new int[] {11, 22, 33, 44, 55, 66, 77, 88, 99}, s.numsSameConsecDiff(2, 0));
        assertArrayEquals(new int[] {131, 135, 202, 242, 246, 313, 353, 357, 420, 424, 464, 468, 531, 535, 575, 579, 642, 646, 686, 753, 757, 797, 864, 868, 975, 979},
                s.numsSameConsecDiff(3, 2));
    }
}
package array.IntersectionOfThreeSortedArrays_1213;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(1, 5), s.arraysIntersection(new int[] {1, 2, 3, 4, 5},
                new int[] {1, 2, 5, 7, 9}, new int[] {1, 3, 4, 5, 8}));
        assertEquals(Arrays.asList(6), s.arraysIntersection(new int[] {6, 7, 8},
                new int[] {1, 2, 3, 6, 9}, new int[] {3, 6, 11}));
        assertEquals(Arrays.asList(), s.arraysIntersection(new int[] {7, 8},
                new int[] {1, 2, 3}, new int[] {2, 3, 9}));
    }
}

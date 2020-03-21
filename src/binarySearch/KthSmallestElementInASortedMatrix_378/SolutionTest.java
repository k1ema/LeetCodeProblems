package binarySearch.KthSmallestElementInASortedMatrix_378;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(13, s.kthSmallest(new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        assertEquals(9, s.kthSmallest(new int[][] {{1, 5, 9}, {2, 6, 10}, {3, 7, 11}}, 7));
        assertEquals(9, s.kthSmallest(new int[][] {{1, 5, 9}, {2, 6, 15}, {19, 20, 27}}, 5));
        assertEquals(7, s.kthSmallest(new int[][] {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}}, 5));
    }
}

package heap.KClosestPointsToOrigin_973;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{-2, 2}}, s.kClosest(new int[][] {{1, 3}, {-2, 2}}, 1));

        int[][] res = s.kClosest(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2);
        Assert.assertEquals(2, res.length);
        for (int[] p : res) {
            Assert.assertTrue(Arrays.compare(new int[] {3, 3}, p) == 0 || Arrays.compare(new int[] {-2, 4}, p) == 0);
        }

        res = s.kClosest(new int[][] {{-2, -6}, {-7, -2}, {-9, 6}, {10, 3}, {-8, 1}, {2, 8}}, 5);
        Assert.assertEquals(5, res.length);
        for (int[] p : res) {
            Assert.assertTrue(Arrays.compare(new int[] {2, 8}, p) == 0 || Arrays.compare(new int[] {-7, -2}, p) == 0
                    || Arrays.compare(new int[] {-2, -6}, p) == 0 || Arrays.compare(new int[] {10, 3}, p) == 0
                    || Arrays.compare(new int[] {-8, 1}, p) == 0);
        }
    }
}
package array.FindTheDistanceValueBetweenTwoArrays_1385;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findTheDistanceValue(new int[] {4, 5, 8},
                new int[] {10, 9, 1, 8}, 2));
        assertEquals(2, s.findTheDistanceValue(new int[] {1,4,2,3},
                new int[] {-4,-3,6,10,20,30}, 3));
        assertEquals(1, s.findTheDistanceValue(new int[] {2,1,100,3},
                new int[] {-5,-2,10,-3,7}, 6));
    }
}
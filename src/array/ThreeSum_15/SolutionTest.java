package array.ThreeSum_15;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<List<Integer>> res = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        assertEquals(res, s.threeSum(new int[] {-1, 0, 1, 2, -1, -4, 1, -1, 0}));
    }
}

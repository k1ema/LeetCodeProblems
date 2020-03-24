package backtracking.CombinationSum_39;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7)
        ), s.combinationSum(new int[] {2, 3, 6, 7}, 7));
        assertEquals(Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
        ), s.combinationSum(new int[] {2, 3, 5}, 8));
    }
}
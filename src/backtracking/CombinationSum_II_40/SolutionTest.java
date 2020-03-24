package backtracking.CombinationSum_II_40;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 1, 6),
                Arrays.asList(2, 6),
                Arrays.asList(1, 7));
        List<List<Integer>> actual = s.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
        test(expected, actual);

        expected = Arrays.asList(Arrays.asList(1, 2, 2), Arrays.asList(5));
        actual = s.combinationSum2(new int[] {2, 5, 2, 1, 2}, 5);
        test(expected, actual);
    }

    private void test(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        for (List<Integer> nums : actual) {
            assertTrue(expected.contains(nums));
        }
    }
}
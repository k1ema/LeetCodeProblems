package backtracking.Permutations_II_47;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 1), Arrays.asList(2, 1, 1)),
                s.permuteUnique(new int[] {1, 1, 2}));
        assertEquals(Arrays.asList(Arrays.asList(1, 2, 2), Arrays.asList(2, 1, 2), Arrays.asList(2, 2, 1)),
                s.permuteUnique(new int[] {1, 2, 2}));
        assertEquals(Arrays.asList(
                Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2), Arrays.asList(3, 2, 1)),
                s.permuteUnique(new int[] {1, 2, 3}));
    }
}

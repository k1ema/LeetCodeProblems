package backtracking.Subsets_II_90;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(1),
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2),
                Arrays.asList(2, 2)
        ), s.subsetsWithDup(new int[] {1, 2, 2}));

        assertEquals(Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(1),
                Arrays.asList(1, 4),
                Arrays.asList(1, 4, 4),
                Arrays.asList(1, 4, 4, 4),
                Arrays.asList(1, 4, 4, 4, 4),
                Arrays.asList(4),
                Arrays.asList(4, 4),
                Arrays.asList(4, 4, 4),
                Arrays.asList(4, 4, 4, 4)
        ), s.subsetsWithDup(new int[] {4, 4, 4, 1, 4}));
    }
}

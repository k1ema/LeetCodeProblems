package array.FourSum_18;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2, 0, 0, 2),
                Arrays.asList(-1, 0, 0, 1)
        ), s.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));

        assertEquals(Arrays.asList(
                Arrays.asList(-3, -2, 2, 3),
                Arrays.asList(-3, -1, 1, 3),
                Arrays.asList(-3, 0, 0, 3),
                Arrays.asList(-3, 0, 1, 2),
                Arrays.asList(-2, -1, 0, 3),
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2, 0, 0, 2),
                Arrays.asList(-1, 0, 0, 1)
        ), s.fourSum(new int[] {-3, -2, -1, 0, 0, 1, 2, 3}, 0));

        assertEquals(Arrays.asList(Arrays.asList(-3, -3, 2, 4)),
                s.fourSum(new int[] {2, 4, 0, 4, -3, -3}, 0));
    }
}
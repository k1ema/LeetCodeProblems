package dynamic.MaximumSumOf3NonOverlappingSubarrays_689;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {0, 3, 5}, s.maxSumOfThreeSubarrays(new int[] {1, 2, 1, 2, 6, 7, 5, 1}, 2));
        assertArrayEquals(new int[] {0, 2, 4}, s.maxSumOfThreeSubarrays(new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1}, 2));
    }
}
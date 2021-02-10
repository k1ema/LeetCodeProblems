package array.NextPermutation_31;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[] nums = new int[] {1, 2, 3};
        s.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 3, 2}, nums);

        nums = new int[] {3, 2, 1};
        s.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 2, 3}, nums);

        nums = new int[] {4, 3, 2, 1};
        s.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 2, 3, 4}, nums);

        nums = new int[] {1, 1, 5};
        s.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 5, 1}, nums);

        nums = new int[] {0, 1, 2, 5, 3, 3, 0};
        s.nextPermutation(nums);
        assertArrayEquals(new int[] {0, 1, 3, 0, 2, 3, 5}, nums);

        nums = new int[] {0, 1, 4, 5, 3, 3, 0};
        s.nextPermutation(nums);
        assertArrayEquals(new int[] {0, 1, 5, 0, 3, 3, 4}, nums);
    }
}

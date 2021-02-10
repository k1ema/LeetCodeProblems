package array.RotateArray_189;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        s.rotate(nums, 3);
        assertArrayEquals(new int[] {5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[] {-1, -100, 3, 99};
        s.rotate(nums, 2);
        assertArrayEquals(new int[] {3, 99, -1, -100}, nums);

        nums = new int[] {-1};
        s.rotate(nums, 2);
        assertArrayEquals(new int[] {-1}, nums);

        nums = new int[] {1, 2};
        s.rotate(nums, 3);
        assertArrayEquals(new int[] {2, 1}, nums);
    }
}
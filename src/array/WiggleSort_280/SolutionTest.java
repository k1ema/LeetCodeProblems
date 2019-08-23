package array.WiggleSort_280;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[] nums = new int[] {3, 5, 2, 1, 6, 4};
        s.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(new int[] {3, 5, 1, 6, 2, 4}, nums);

        nums = new int[] {7, 6, 5, 4, 1, 2, 3};
        s.wiggleSort(nums);
        assertArrayEquals(new int[] {6, 7, 4, 5, 1, 3, 2}, nums);

        nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        s.wiggleSort(nums);
        assertArrayEquals(new int[] {1, 3, 2, 5, 4, 7, 6}, nums);
    }
}

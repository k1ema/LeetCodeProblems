package array.MergeSortedArray_88;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        s.merge(nums1, 3, new int[] {2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
        Assert.assertArrayEquals(new int[] {1, 2, 2, 3, 5, 6}, nums1);

        nums1 = new int[] {5, 6, 7, 0, 0, 0, 0};
        s.merge(nums1, 3, new int[] {1, 2, 3, 4}, 4);
        System.out.println(Arrays.toString(nums1));
        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7}, nums1);

        nums1 = new int[] {0, 1, 6, 7, 11, 0, 0, 0, 0};
        s.merge(nums1, 5, new int[] {2, 3, 4, 10}, 4);
        System.out.println(Arrays.toString(nums1));
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 6, 7, 10, 11}, nums1);
    }
}

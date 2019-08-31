package sorting.MergeSort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    private MergeSort mergeSort;

    @Before
    public void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void test() {
        testSort(new int[] {11, 16, 8, 12, 15, 6, 3, 9, 5}, new int[] {3, 5, 6, 8, 9, 11, 12, 15, 16});
        testSort(new int[] {9, 7, 6, 5, 4, 3, 2, 1}, new int[] {1, 2, 3, 4, 5, 6, 7, 9});
        testSort(new int[] {8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1}, new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8});
    }

    private void testSort(int[] nums, int[] expectedNums) {
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(expectedNums, nums);
    }
}

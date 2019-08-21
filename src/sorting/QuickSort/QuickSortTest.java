package sorting.QuickSort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {
    private QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void test() {
        testPartition(new int[] {10, 16, 8, 12, 15, 6, 3, 9, 5}, 5);
        testPartition(new int[] {7, 6, 5, 4, 3, 2, 1}, 6);
        testPartition(new int[] {7, 7, 6, 5, 4, 3, 2, 1}, 7);
        testPartition(new int[] {1, 2, 3, 4, 5, 6, 7}, 0);

        testSort(new int[] {10, 16, 8, 12, 15, 6, 3, 9, 5}, new int[] {3, 5, 6, 8, 9, 10, 12, 15, 16});
        testSort(new int[] {8, 7, 6, 5, 4, 3, 2, 1}, new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        testSort(new int[] {8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1}, new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8});
    }

    private void testPartition(int[] nums, int expectedIndex) {
        int ind = quickSort.partition(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        assertEquals(expectedIndex, ind);
    }

    private void testSort(int[] nums, int[] expectedNums) {
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(expectedNums, nums);
    }
}

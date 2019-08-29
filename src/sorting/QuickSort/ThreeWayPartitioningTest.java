package sorting.QuickSort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ThreeWayPartitioningTest {
    @Test
    public void test() {
        ThreeWayPartitioning s = new ThreeWayPartitioning();
        int[] nums = {2, 0, 2, 1, 1, 0};
        s.sort(nums);
        assertArrayEquals(new int[] {0, 0, 1, 1, 2, 2}, nums);

        nums = new int[] {2, 0, 2, 2, 2, 1};
        s.sort(nums);
        assertArrayEquals(new int[] {0, 1, 2, 2, 2, 2}, nums);

        nums = new int[] {1, 0, 0, 0, 0, 2};
        s.sort(nums);
        assertArrayEquals(new int[] {0, 0, 0, 0, 1, 2}, nums);

        nums = new int[] {2, 0, 0, 0, 0, 2};
        s.sort(nums);
        assertArrayEquals(new int[] {0, 0, 0, 0, 2, 2}, nums);

        nums = new int[] {1, 0};
        s.sort(nums);
        assertArrayEquals(new int[] {0, 1}, nums);

        nums = new int[] {0, 0, 0};
        s.sort(nums);
        assertArrayEquals(new int[] {0, 0, 0}, nums);

        nums = new int[] {1, 1, 1};
        s.sort(nums);
        assertArrayEquals(new int[] {1, 1, 1}, nums);

        nums = new int[] {2, 2, 2};
        s.sort(nums);
        assertArrayEquals(new int[] {2, 2, 2}, nums);

        nums = new int[] {1, 0, 1};
        s.sort(nums);
        assertArrayEquals(new int[] {0, 1, 1}, nums);

        nums = new int[] {1, 2, 0};
        s.sort(nums);
        assertArrayEquals(new int[] {0, 1, 2}, nums);
    }
}

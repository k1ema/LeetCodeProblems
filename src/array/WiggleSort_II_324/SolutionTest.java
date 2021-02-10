package array.WiggleSort_II_324;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[] nums = new int[] {1, 5, 1, 1, 6, 4};
        s.wiggleSort(nums);
        boolean b1 = Arrays.equals(new int[] {1, 4, 1, 5, 1, 6}, nums);
        boolean b2 = Arrays.equals(new int[] {1, 4, 1, 6, 1, 5}, nums);
        boolean b3 = Arrays.equals(new int[] {1, 5, 1, 6, 1, 4}, nums);
        boolean b4 = Arrays.equals(new int[] {1, 5, 1, 4, 1, 6}, nums);
        boolean b5 = Arrays.equals(new int[] {1, 6, 1, 4, 1, 5}, nums);
        boolean b6 = Arrays.equals(new int[] {1, 6, 1, 5, 1, 4}, nums);
        assertTrue(b1 | b2 | b3 | b4 | b5 | b6);

        nums = new int[] {1, 3, 2, 2, 3, 1};
        s.wiggleSort(nums);
        assertArrayEquals(new int[] {2, 3, 1, 3, 1, 2}, nums);

        nums = new int[] {1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2};
        s.wiggleSort(nums);
        assertArrayEquals(new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2}, nums);

        nums = new int[] {4, 5, 5, 6};
        s.wiggleSort(nums);
        assertArrayEquals(new int[] {5, 6, 4, 5}, nums);

        nums = new int[] {3, 2, 3, 3, 2, 1, 1, 2, 3, 1, 1, 3, 2, 1, 2, 2, 2, 2, 1};
        s.wiggleSort(nums);
        assertArrayEquals(new int[] {2, 3, 2, 3, 2, 3, 2, 3, 1, 3, 1, 2, 1, 2, 1, 2, 1, 2, 1}, nums);

        nums = new int[] {1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2};
        s.wiggleSort(nums);
        assertArrayEquals(new int[] {2, 3, 1, 3, 1, 2, 1, 2, 1, 2, 1}, nums);

        nums = new int[] {1, 1, 2, 1, 2, 2, 1};
        s.wiggleSort(nums);
        assertArrayEquals(new int[] {1, 2, 1, 2, 1, 2, 1}, nums);
    }
}

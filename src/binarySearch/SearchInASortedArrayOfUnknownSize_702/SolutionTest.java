package binarySearch.SearchInASortedArrayOfUnknownSize_702;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[] nums = new int[] {-1, 0, 3, 5, 9, 12};
        Solution.ArrayReader ar = i -> i < 0 || i >= nums.length ? Integer.MAX_VALUE : nums[i];
        Assert.assertEquals(4, s.search(ar, 9));
        Assert.assertEquals(-1, s.search(ar, 2));
        Assert.assertEquals(-1, s.search(ar, 13));
        Assert.assertEquals(6, s.search(ar, Integer.MAX_VALUE));
    }
}
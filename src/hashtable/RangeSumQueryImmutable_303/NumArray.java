package hashtable.RangeSumQueryImmutable_303;

import java.util.HashMap;
import java.util.Map;

/**
 * 303. Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Given an integer array nums, find the sum of the elements between indices i and j
 * (i ≤ j), inclusive.
 *
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int i, int j) Return the sum of the elements of the nums array in the
 * range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
 *
 * Example 1:
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 * Constraints:
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * At most 104 calls will be made to sumRange.
 */
public class NumArray {
    /*

    -2, 0, 3, -5, 2, -1
    -2  0  1  -4 -2  -3

    res(j,i) = sum[j] - sum[i] + nums[i]
*/
    // tc O(n), sc O(n)
    // prefix sum
    private final Map<Integer, Integer> map;
    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(i, sum);
        }
    }

    public int sumRange(int i, int j) {
        return map.get(j) - map.get(i) + nums[i];
    }
}

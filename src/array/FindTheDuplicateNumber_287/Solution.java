package array.FindTheDuplicateNumber_287;

import java.util.Arrays;

/**
 * 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2

 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3

 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 0 ms, faster than 100.00%; 36.3 MB, less than 100.00%
    int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int ptr1 = 0;
        int ptr2 = fast;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }

    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72844/Two-Solutions-(with-explanation)%3A-O(nlog(n))-and-O(n)-time-O(1)-space-without-changing-the-input-array
    // tc O(nlogn), sc O(1)
    // 3 ms, faster than 48.33%; 36.7 MB, less than 100.00%
    int findDuplicate1(int[] nums) {
        int lo = 1;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int cnt = 0;
            int mid = (lo + hi) >>> 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // tc O(n*logn), sc O(1), does not apply solution requirements (array is read only)
    int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}

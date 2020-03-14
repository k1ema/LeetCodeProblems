package array.FindAllNumbersDisappearedInAnArray_448;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not
 * count as extra space.
 *
 * Example:
 *
 *  Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class Solution {
    // tc O(n), sc O(1)
    // 5 ms, faster than 85.97%; 48.3 MB, less than 35.85%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if (nums[ind] > 0) {
                nums[ind] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }

    // tc O(n), sc O(n)
    // 3 ms, faster than 100.00%; 50.3 MB, less than 32.08%
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int[] a = new int[nums.length + 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = 0;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) res.add(a[i]);
        }
        return res;
    }
}

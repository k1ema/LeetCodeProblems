package string.NextGreaterElement_III_556;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 556. Next Greater Element III
 * https://leetcode.com/problems/next-greater-element-iii/
 *
 * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the
 * integer n and is greater in value than n. If no such positive integer exists, return -1.
 *
 * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not
 * fit in 32-bit integer, return -1.
 *
 * Example 1:
 * Input: n = 12
 * Output: 21
 *
 * Example 2:
 * Input: n = 21
 * Output: -1
 *
 * Constraints:
 * 1 <= n <= 2^31 - 1
 *
 */
public class Solution {
    // tc O(n), sc O(n), where n - number of digits
    // 0 ms, faster than 100.00%; 35.4 MB, less than 95.27%
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j = nums.length - 1;
                while (j > i && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
                reverse(nums, i + 1);
                long l = Long.parseLong(new String(nums));
                return l <= Integer.MAX_VALUE ? (int) l : -1;
            }
        }
        return -1;
    }

    private void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(char[] nums, int from) {
        int i = from, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    // brute force, tc O(n*n!), sc O(n!)
    // 176 ms; 97.7 MB
    public int nextGreaterElement1(int n) {
        if (n < 10) return -1;
        char[] nums = Integer.toString(n).toCharArray();
        Arrays.sort(nums);
        List<String> list = new ArrayList<>();
        bt(nums, new boolean[nums.length], new StringBuilder(), list);
        Collections.sort(list);
        String nStr = "" + n;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(nStr) && i != list.size() - 1) {
                long l = Long.parseLong(list.get(i + 1));
                return l < Integer.MAX_VALUE ? (int) l : -1;
            }
        }
        return -1;
    }

    private void bt(char[] nums, boolean[] used, StringBuilder sb, List<String> list) {
        if (sb.length() == nums.length) {
            list.add(sb.toString());
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            sb.append(nums[i]);
            bt(nums, used, sb, list);
            sb.setLength(sb.length() - 1);
            used[i] = false;
        }
    }
}

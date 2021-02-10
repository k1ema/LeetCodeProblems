package array.CountLargestGroup_1399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1399. Count Largest Group
 * https://leetcode.com/problems/count-largest-group/
 *
 * Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
 *
 * Return how many groups have the largest size.
 *
 * Example 1:
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of its digits of
 * numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
 *
 * Example 2:
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 *
 * Example 3:
 * Input: n = 15
 * Output: 6
 *
 * Example 4:
 * Input: n = 24
 * Output: 5
 *
 * Constraints:
 * 1 <= n <= 10^4
 */
public class Solution {
    // tc O(n), sc O(n)
    // 8 ms, faster than 40.00%; 38.6 MB, less than 100.00%
    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int v = i;
            int sum = 0;
            while (v > 0) {
                sum += v % 10;
                v = v / 10;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }
        int max = 0;
        for (List<Integer> list : map.values()) {
            max = Math.max(max, list.size());
        }
        int count = 0;
        for (List<Integer> list : map.values()) {
            if (list.size() == max) count++;
        }
        return count;
    }
}

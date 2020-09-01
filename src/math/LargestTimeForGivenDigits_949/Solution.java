package math.LargestTimeForGivenDigits_949;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 949. Largest Time for Given Digits
 * https://leetcode.com/problems/largest-time-for-given-digits/
 *
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is
 * larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 * Example 1:
 * Input: [1,2,3,4]
 * Output: "23:41"
 *
 * Example 2:
 * Input: [5,5,5,5]
 * Output: ""
 *
 * Note:
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class Solution {
    // tc O(1), sc O(1)
    // 29 ms, 40.6 MB
    public String largestTimeFromDigits(int[] A) {
        String res = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || i == k || j == k) continue;
                    String h = "" + A[i] + A[j], m = "" + A[k] + A[6 - i - j - k], t = h + ":" + m;
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && res.compareTo(t) < 0) {
                        res = t;
                    }
                }
            }
        }
        return res;
    }

    // my solution
    // tc O(n * n!), sc O(n), since n = 4, tc O(1), sc O(1)
    // 19 ms, faster than 21.42%; 40.1 MB, less than 14.60%
    public String largestTimeFromDigits1(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> list = new ArrayList<>();
        bt(list, A, new ArrayList<>(), new boolean[A.length]);
        list.sort((a, b) -> {
            if (b.get(0) != a.get(0)) {
                return b.get(0) - a.get(0);
            } else if (b.get(1) != a.get(1)) {
                return b.get(1) - a.get(1);
            } else if (b.get(2) != a.get(2)) {
                return b.get(2) - a.get(2);
            } else {
                return b.get(3) - a.get(3);
            }
        });
        if (list.isEmpty()) {
            return "";
        }
        List<Integer> l = list.get(0);
        return "" + l.get(0) + l.get(1) + ":" + l.get(2) + l.get(3);
    }

    private void bt(List<List<Integer>> list, int[] nums, List<Integer> helper, boolean[] used) {
        if (helper.size() == nums.length) {
            if (validTime(helper)) {
                list.add(new ArrayList<>(helper));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            helper.add(nums[i]);
            bt(list, nums, helper, used);
            helper.remove(helper.size() - 1);
            used[i] = false;
        }
    }

    private boolean validTime(List<Integer> t) {
        return (t.get(0) <= 1 || t.get(0) == 2 && t.get(1) <= 3) && t.get(2) <= 5;
    }
}

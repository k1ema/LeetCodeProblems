package dynamic.KConcatenationMaximumSum_1191;

/**
 * 1191. K-Concatenation Maximum Sum
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 *
 * Given an integer array arr and an integer k, modify the array by repeating it k times.
 *
 * For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
 *
 * Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
 *
 * As the answer can be very large, return the answer modulo 10^9 + 7.
 *
 * Example 1:
 * Input: arr = [1,2], k = 3
 * Output: 9
 *
 * Example 2:
 * Input: arr = [1,-2,1], k = 5
 * Output: 2
 *
 * Example 3:
 * Input: arr = [-1,-2], k = 7
 * Output: 0
 *
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 */
public class Solution {
    // tc O(n), sc O(1)
    // 2 ms, faster than 98.38%; 52.3 MB, less than 61.13%
    // https://leetcode.com/problems/k-concatenation-maximum-sum/discuss/382350/Java-Solution(Kadens-Algo)-with-Explanation
    /*
                               omit fromLeft             omit fromRight
                                 <----->                     <----->
        [5,2,-10,2,4], k = 3 -> [5,2,-10,2,4,5,2,-10,2,4,5,2,-10,2,4]
                                         ^-----------------^
                                              take this
     */
    public int kConcatenationMaxSum(int[] arr, int k) {
        if (arr.length == 0) return 0;
        int mod = (int) 1e9 + 7, n = arr.length;
        int cur = 0, maxKadane = 0, fromLeft = 0, fromRight = 0;
        for (int i = 0; i < n; i++) {
            cur = Math.max(cur + arr[i], arr[i]);
            maxKadane = Math.max(maxKadane, cur);
        }
        if (k == 1) return maxKadane;

        cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur += arr[i];
            fromLeft = Math.max(fromLeft, cur);
        }

        cur = 0;
        for (int i = 0; i < n; i++) {
            cur += arr[i];
            fromRight = Math.max(fromRight, cur);
        }

        int sum = cur;
        if (sum < 0) {
            return Math.max(maxKadane, fromRight + fromLeft);
        } else {
            long res = ((long) sum) * (k - 2) % mod + fromRight + fromLeft;
            return Math.max((sum * k) % mod, (int) (res % mod));
        }
    }
}

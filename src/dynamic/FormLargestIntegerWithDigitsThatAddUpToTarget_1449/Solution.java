package dynamic.FormLargestIntegerWithDigitsThatAddUpToTarget_1449;

/**
 * 1449. Form Largest Integer With Digits That Add up to Target
 * https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
 *
 * Given an array of integers cost and an integer target. Return the maximum integer you
 * can paint under the following rules:
 *
 * The cost of painting a digit (i+1) is given by cost[i] (0 indexed).
 * The total cost used must be equal to target.
 * Integer does not have digits 0.
 * Since the answer may be too large, return it as string.
 *
 * If there is no way to paint any integer given the condition, return "0".
 *
 * Example 1:
 * Input: cost = [4,3,2,5,6,7,2,5,5], target = 9
 * Output: "7772"
 *
 * Explanation:  The cost to paint the digit '7' is 2, and the digit '2' is 3. Then cost("7772") = 2*3+ 3*1 = 9. You could also paint "997", but "7772" is the largest number.
 * Digit    cost
 *   1  ->   4
 *   2  ->   3
 *   3  ->   2
 *   4  ->   5
 *   5  ->   6
 *   6  ->   7
 *   7  ->   2
 *   8  ->   5
 *   9  ->   5
 *
 * Example 2:
 * Input: cost = [7,6,5,5,5,6,8,7,8], target = 12
 * Output: "85"
 * Explanation: The cost to paint the digit '8' is 7, and the digit '5' is 5. Then cost("85") = 7 + 5 = 12.
 *
 * Example 3:
 * Input: cost = [2,4,6,2,4,6,4,4,4], target = 5
 * Output: "0"
 * Explanation: It's not possible to paint any integer with total cost equal to target.
 *
 * Example 4:
 * Input: cost = [6,10,15,40,40,40,40,40,40], target = 47
 * Output: "32211"
 *
 * Constraints:
 * cost.length == 9
 * 1 <= cost[i] <= 5000
 * 1 <= target <= 5000
 */
public class Solution {
    // https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/discuss/635267/C%2B%2BJavaPython-Strict-O(Target)
    public String largestNumber1(int[] cost, int target) {
        int[] dp = new int[target + 1];
        for (int t = 1; t <= target; ++t) {
            dp[t] = -10000;
            for (int i = 0; i < 9; ++i) {
                if (t >= cost[i]) {
                    dp[t] = Math.max(dp[t], 1 + dp[t - cost[i]]);
                }
            }
        }
        if (dp[target] < 0) return "0";
        StringBuilder res = new StringBuilder();
        for (int i = 8; i >= 0; --i) {
            while (target >= cost[i] && dp[target] == dp[target - cost[i]] + 1) {
                res.append(1 + i);
                target -= cost[i];
            }
        }
        return res.toString();
    }

    // bt with memoization
    // https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/discuss/635190/C%2B%2B-Top-Down-greater-Bottom-Up-greater-O(n)
    private String[] dp;
    public String largestNumber(int[] cost, int target) {
        dp = new String[target + 1];
        bt(cost, target);
        return dp[target];
    }

    private String bt(int[] cost, int target) {
        if (target <= 0) {
            return target == 0 ? "" : "0";
        }
        if (dp[target] == null) {
            dp[target] = "0";
            for (int i = 1; i <= 9; i++) {
                String res = bt(cost, target - cost[i - 1]);
                if (!res.equals("0") && res.length() + 1 >= dp[target].length()) {
                    dp[target] = i + res;
                }
            }
        }
        return dp[target];
    }
}

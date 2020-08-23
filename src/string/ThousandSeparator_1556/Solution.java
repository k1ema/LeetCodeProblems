package string.ThousandSeparator_1556;

/**
 * 1556. Thousand Separator
 * https://leetcode.com/problems/thousand-separator/
 *
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 *
 * Example 1:
 * Input: n = 987
 * Output: "987"
 *
 * Example 2:
 * Input: n = 1234
 * Output: "1.234"
 *
 * Example 3:
 * Input: n = 123456789
 * Output: "123.456.789"
 *
 * Example 4:
 * Input: n = 0
 * Output: "0"
 *
 * Constraints:
 * 0 <= n < 2^31
 */
public class Solution {
    // 8 ms, faster than 100.00%; 37.8 MB, less than 100.00%
    public String thousandSeparator(int n) {
        if (n == 0) return "0";
        int count = 0;
        String res = "";
        while (n > 0) {
            res = "" + (n % 10) + res;
            count++;
            n /= 10;
            if (n > 0 && count % 3 == 0) {
                res = "." + res;
            }
        }
        return res;
    }
}

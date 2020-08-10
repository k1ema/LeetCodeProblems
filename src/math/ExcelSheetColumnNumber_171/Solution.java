package math.ExcelSheetColumnNumber_171;

/**
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * Example 1:
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 * Input: "ZY"
 * Output: 701
 *
 * Constraints:
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 */
public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int v = s.charAt(i) - 'A' + 1;
            res += v * Math.pow(26, n - i - 1);
        }
        return res;
    }
}

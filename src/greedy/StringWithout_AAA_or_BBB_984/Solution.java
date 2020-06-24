package greedy.StringWithout_AAA_or_BBB_984;

/**
 * 984. String Without AAA or BBB
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 *
 * Given two integers A and B, return any string S such that:
 *
 * S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
 * The substring 'aaa' does not occur in S;
 * The substring 'bbb' does not occur in S.
 *
 * Example 1:
 * Input: A = 1, B = 2
 * Output: "abb"
 * Explanation: "abb", "bab" and "bba" are all correct answers.
 *
 * Example 2:
 * Input: A = 4, B = 1
 * Output: "aabaa"
 *
 * Note:
 * 0 <= A <= 100
 * 0 <= B <= 100
 * It is guaranteed such an S exists for the given A and B.
 */
public class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while (A > 0 || B > 0) {
            boolean writeA = false;
            int l = sb.length();
            if (l >= 2 && sb.charAt(l - 1) == sb.charAt(l - 2)) {
                if (sb.charAt(l - 1) == 'b') {
                    writeA = true;
                }
            } else {
                if (A >= B) writeA = true;
            }

            if (writeA) {
                sb.append("a");
                A--;
            } else {
                sb.append("b");
                B--;
            }
        }
        return sb.toString();
    }
}

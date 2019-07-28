package string.AddBinary_67;

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class Solution {
    // https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation
    // tc O(n), sc O(n);  n = max(a.len, b.len)
    String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    // my solution
    private int rem = 0;
    String addBinary1(String a, String b) {
        rem = 0;
        StringBuilder sb = new StringBuilder();
        if (a.length() < b.length()) {
            a = equalLen(a, b.length());
        } else if (a.length() > b.length()) {
            b = equalLen(b, a.length());
        }

        for (int i = a.length() - 1; i >= 0; i--) {
            int aa = a.charAt(i) - '0';
            int bb = b.charAt(i) - '0';
            sb.append(aa ^ bb ^ rem);
            if (aa == 1 && bb == 1 || ((aa == 1 | bb == 1) && rem == 1)) {
                rem = 1;
            } else {
                rem = 0;
            }
        }
        if (rem == 1) {
            sb.append(rem);
        }
        return sb.reverse().toString();
    }

    private String equalLen(String s, int len) {
        while (s.length() < len) {
            s = "0" + s;
        }
        return s;
    }
}

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
    // my solution
    // tc O(n), sc O(n);  n = max(a.len, b.len)
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int ai = i >= 0 ? a.charAt(i) - '0' : 0;
            int bj = j >= 0 ? b.charAt(j) - '0' : 0;
            int res = carry == 0 ? ai ^ bj : carry ^ (ai ^ bj);
            carry = (ai == 1 && bj == 1 || carry == 1 && (ai == 1 || bj == 1)) ? 1 : 0;
            sb.append(res);
            i--; j--;
        }
        if (carry == 1) sb.append("1");
        return sb.reverse().toString();
    }

    // https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation
    // tc O(n), sc O(n);  n = max(a.len, b.len)
    String addBinary1(String a, String b) {
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
}

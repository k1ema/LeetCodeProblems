package stack.RemoveKDigits_402;

import java.util.LinkedList;

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 *
 * Given a non-negative integer num represented as a string, remove k digits from the
 * number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Solution {
    // tc O(n), sc O(n)
    // https://leetcode.com/problems/remove-k-digits/solution/
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for(char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.removeFirst();
                k--;
            }
            stack.addFirst(c);
        }

        for (int i = 0; i < k; i++) {
            stack.removeFirst();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char c = stack.removeLast();
            if (leadingZero && c == '0') continue;
            leadingZero = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    // using backtracking tc O(C(n, k)) - TLE, sc O(C(n,k))
    public String removeKdigits1(String num, int k) {
        String res = bt(num, 0, k, "");
        return res.isEmpty() ? "0" : res;
    }

    private String bt(String num, int ind, int k, String prefix) {
        if (ind == num.length()) return prefix;
        String cur = num.substring(ind);
        if (k == 0) return prefix + cur;
        String s1 = removeLeadingZero(bt(num, ind + 1, k, prefix + num.charAt(ind)));
        String s2 = removeLeadingZero(bt(num, ind + 1, k - 1, prefix));
        String s = compare(s1, s2) <= 0 ? s1 : s2;
        return s;
    }

    private String removeLeadingZero(String s) {
        if (s.length() <= 1) return s;
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
    }

    private int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }
        int i = 0;
        while (i < s1.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i == s1.length() ? 0 : s1.charAt(i) - s2.charAt(i);
    }
}

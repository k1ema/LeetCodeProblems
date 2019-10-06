package string.ValidPalindrome_III_1216;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1216. Valid Palindrome III
 * https://leetcode.com/contest/biweekly-contest-10/problems/valid-palindrome-iii/
 *
 * Given a string s and an integer k, find out if the given string is a K-Palindrome or not.
 *
 * A string is K-Palindrome if it can be transformed into a palindrome by removing at most k
 * characters from it.
 *
 * Example 1:
 * Input: s = "abcdeca", k = 2
 * Output: true
 * Explanation: Remove 'b' and 'e' characters.
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s has only lowercase English letters.
 * 1 <= k <= s.length
 */
public class Solution {
    // TODO: Time limit exceeded
    boolean isValidPalindrome(String s, int k) {
        int slen = s.length();
        List<Set<Integer>> combine = combine(slen, k);
        for (Set<Integer> nums : combine) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < slen; i++) {
                if (nums.contains(i + 1)) continue;
                sb.append(s.charAt(i));
            }
            if (isPalindrome(sb.toString())) return true;
        }
        return false;
    }

    boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;

        int len = s.length();
        int p1 = 0;
        int p2 = len - 1;
        while (p1 <= p2) {
            char c1 = s.charAt(p1);
            if (!Character.isLetterOrDigit(c1)) {
                p1++;
                continue;
            }
            char c2 = s.charAt(p2);
            if (!Character.isLetterOrDigit(c2)) {
                p2--;
                continue;
            }
            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }

    private List<Set<Integer>> combine(int n, int k) {
        List<Set<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<Set<Integer>> combs, List<Integer> temp, int start, int n, int k) {
        if (k == 0) {
            combs.add(new HashSet<>(temp));
            return;
        }

        for (int i = start; i <= n-k+1; i++) {
            temp.add(i);
            backtrack(combs, temp, i + 1, n, k - 1);
            temp.remove(temp.size() - 1);
        }
    }
}

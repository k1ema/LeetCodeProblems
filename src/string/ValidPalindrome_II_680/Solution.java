package string.ValidPalindrome_II_680;

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class Solution {
    /*
          v
        abcbfa
    */
    public boolean validPalindrome(String s) {
        if (s == null) return false;
        if (s.length() < 2) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                boolean b1 = isPalindrome(s, i + 1, j);
                boolean b2 = isPalindrome(s, i, j - 1);
                return b1 || b2;
            }
            i++; j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}

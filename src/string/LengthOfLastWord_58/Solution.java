package string.LengthOfLastWord_58;

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the
 * length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class Solution {
    // tc O(n), sc O(1)
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        int len = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }

    // tc O(n), sc O(n)
    public int lengthOfLastWord1(String s) {
        if (s == null) return 0;
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}

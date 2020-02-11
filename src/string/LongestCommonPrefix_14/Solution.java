package string.LongestCommonPrefix_14;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class Solution {
    // tc O(n * m), sc O(n), n - min str, m - strs.length
    String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str == null) return "";
            min = Math.min(min, str.length());
        }
        for (int i = 0; i < min; i++) {
            sb.append(strs[0].charAt(i));
            for (String str : strs) {
                if (str.charAt(i) !=  sb.charAt(sb.length() - 1)) {
                    return sb.deleteCharAt(i).toString();
                }
            }
        }
        return sb.toString();
    }
}

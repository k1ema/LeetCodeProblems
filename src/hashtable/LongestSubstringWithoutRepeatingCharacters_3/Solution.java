package hashtable.LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *  Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *  Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {
    // tc O(n), sc O(1)
    int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int longest = 0;
        for (int j = 1, i = 0; j < s.length(); j++) {
            char ss = s.charAt(j);
            while (s.substring(i, j).indexOf(ss) > -1) {
                longest = Math.max(longest, s.substring(i, j).length());
                i++;
            }
            longest = Math.max(longest, s.substring(i, j + 1).length());
        }
        return longest;
    }

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
    // tc O(n)
    int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}

package hashtable.LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    /*
        sliding window
        1. init l, r int variables, Set dict
        2. move r ptr and check if cur char in the dict
            if it is
                continue removing from dict left char and increment it while dict does not contain right char
            add right char to dict
            increment r
            update result
    */
    // tc O(n), sc O(n)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> dict = new HashSet<>();
        int res = 0, l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (dict.contains(c)) {
                while (l < r && dict.contains(c)) {
                    dict.remove(s.charAt(l++));
                }
            }
            dict.add(c);
            r++;
            res = Math.max(res, r - l);
        }
        return res;
    }

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
    // tc O(n), sc O(n)
    int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}

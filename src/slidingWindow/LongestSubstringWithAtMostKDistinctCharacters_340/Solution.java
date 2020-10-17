package slidingWindow.LongestSubstringWithAtMostKDistinctCharacters_340;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * Given a string, find the length of the longest substring T that contains
 * at most k distinct characters.
 *
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 *
 * Example 2:
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 */
public class Solution {
    // tc O(n), sc O(k)
    // 6 ms, faster than 79.48%; 38.9 MB, less than 8.55%
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() * k == 0) return 0;
        int n = s.length();
        int res = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            char r = s.charAt(right++);
            map.put(r, map.getOrDefault(r, 0) + 1);
            while (map.size() == k + 1) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                if (map.get(l) == 0) {
                    map.remove(l);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    // tc O(n*k), sc O(k)
    // 12 ms, faster than 30.40%; 39.4 MB, less than 8.55%
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        if (s == null || s.length() * k == 0) return 0;
        int n = s.length();
        int res = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(s.charAt(right), right++);
            if (map.size() == k + 1) {
                int min_idx = Collections.min(map.values());
                map.remove(s.charAt(min_idx));
                left = min_idx + 1;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}

package slidingWindow.LongestSubstringWithAtMostTwoDistinctCharacters_159;

import java.util.*;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 *
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Example 1:
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 *
 * Example 2:
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class Solution {
    // keep track of last two characters and their right most indices. If size of map gt 2 -> remove entry with min index.
    // tc O(n), sc O(1)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, r);
            if (map.size() > 2) {
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                l = del_idx + 1;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    // my solution: keep track of last two characters and all their indices. but could be made simpler - see prev solution
    // tc O(n), sc O(1)
    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Set<Integer>> map = new HashMap<>();
        int l = 0, r = 0, res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            map.putIfAbsent(c, new HashSet<>());
            map.get(c).add(r);
            while (map.size() > 2) {
                char toRemove = s.charAt(l);
                Set<Integer> indexes = map.get(toRemove);
                indexes.remove(l++);
                if (indexes.size() == 0) {
                    map.remove(toRemove);
                }
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    // brute force, tc O(n^2), sc O(1)
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() <= 2) {
                    res = Math.max(res, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}

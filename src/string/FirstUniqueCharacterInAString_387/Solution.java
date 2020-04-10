package string.FirstUniqueCharacterInAString_387;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 8 ms, faster than 75.50%; 40.5 MB, less than 5.71%
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

    // tc O(n), sc O(1)
    // one path traversal
    // 6 ms, faster than 88.00%; 40.1 MB, less than 5.71%
    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) return -1;
        int n = s.length();
        int[] countChars = new int[26];
        int[] indexes = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            countChars[c - 'a']++;
            indexes[c - 'a'] = i;
        }

        int minIndex = n;
        for (int i = 0; i < indexes.length; i++) {
            if (countChars[i] == 1) minIndex = Math.min(minIndex, indexes[i]);
        }

        return minIndex == n ? -1 : minIndex;
    }
}

package hashtable.IsomorphicStrings_205;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of
 * characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Note:
 * You may assume both s and t have the same length.
 */
public class Solution {
    // 11 ms, faster than 42.85%; 40.1 MB
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        Map<Integer, Integer> mapka = new HashMap<>();
        Map<Integer, Integer> mapkaReversed = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int sc = s.charAt(i);
            int tc = t.charAt(i);
            if (mapka.containsKey(sc)) {
                if (mapka.get(sc) != tc) return false;
            } else {
                if (mapkaReversed.containsKey(tc)) {
                    return false;
                } else {
                    mapka.put(sc, tc);
                    mapkaReversed.put(tc, sc);
                }
            }
        }
        return true;
    }

    // https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution
    // 6 ms, faster than 81.63%; 40.5 MB, less than 5.24%
    public boolean isIsomorphic1(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            } else {
                m1[s.charAt(i)] = i + 1;
                m2[t.charAt(i)] = i + 1;
            }
        }
        return true;
    }
}

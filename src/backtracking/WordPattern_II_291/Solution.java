package backtracking.WordPattern_II_291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 291. Word Pattern II
 * https://leetcode.com/problems/word-pattern-ii/
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern
 * and a non-empty substring in str.
 *
 * Example 1:
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 *
 * Example 2:
 * Input: pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 *
 * Example 3:
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 *
 * Constraints:
 * You may assume both pattern and str contains only lowercase letters.
 */
public class Solution {
    // 32 ms, faster than 71.84%; 39.6 MB, less than 74.49%
    // https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution
    public boolean wordPatternMatch(String pattern, String str) {
        boolean b1 = pattern == null || pattern.isEmpty();
        boolean b2 = str == null || str.isEmpty();
        if (b1 && b2) return true;
        if (b1 || b2) return false;
        return isMatch(pattern, 0, str, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean isMatch(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() || j == str.length()) return false;

        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (str.startsWith(s, j)) {
                return isMatch(pattern, i + 1, str, j + s.length(), map, set);
            }
        } else {
            for (int k = j; k < str.length(); k++) {
                String word = str.substring(j, k + 1);

                if (set.contains(word)) {  // ?
                    continue;
                }

                map.put(c, word);
                set.add(word);

                if (isMatch(pattern, i + 1, str, k + 1, map, set)) return true;

                map.remove(c);
                set.remove(word);
            }
        }

        return false;
    }
}

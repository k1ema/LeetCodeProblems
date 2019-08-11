package slidingWindow.MinimumWindowSubstring_76;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 *
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique
 * minimum window in S.
 */
public class Solution {
    // tc O(|s| + |t|)
    // https://leetcode.com/problems/minimum-window-substring/discuss/26810/Java-solution.-using-two-pointers-%2B-HashMap
    String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || s.length() < t.length()) {
            return "";
        }

        // map to keep counters for each char in t. Chars could repeat in t.
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, Integer::sum);
        }

        int left = 0;
        int minLen = s.length() + 1;
        int minLeft = 0;
        int count = 0;
        // move right bound every time
        // decrease char counter from the map, if current char exists in t.
        // if that char counter non negative -> we should count it
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                // we should update the counter of char in any case
                // map.get(rightChar) - it could be less then 0, and this is ok.
                // Because we could found the same char more then one time.
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) >= 0) {
                    count++;
                }
            }

            // if we found all the chars from t, start moving left till we lost some of the chars from t.
            // In this moment we leave the "while" loop and continue moving the right bound till we get all the
            // chars from t again.
            while (count == t.length()) {
                char leftChar = s.charAt(left);
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }

        return minLen > s.length() ?  "" : s.substring(minLeft, minLeft + minLen);
    }
}

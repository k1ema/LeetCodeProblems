package divide_and_conquer.LongestSubstringWithAtLeastKRepeatingCharacters_395;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * Given a string s and an integer k, return the length of the longest substring of s such that the
 * frequency of each character in this substring is greater than or equal to k.
 *
 * Example 1:
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 * Example 2:
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 105
 */
public class Solution {
    // tc O(n^2), sc O(n)
    // In cases where we perform split at every index, the maximum depth of recursive call could be O(N).
    // For each recursive call it takes O(N) time to build the freq resulting in O(n^2) time complexity.
    public int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length());
    }

    private int longestSubstring(String s, int k, int start, int end) {
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        boolean valid = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] < k) {
                valid = false;
                break;
            }
        }

        if (valid) return end - start;

        int cur = start, localMax = 0;
        while (cur < end) {
            if (freq[s.charAt(cur) - 'a'] < k) {
                localMax = Math.max(localMax, longestSubstring(s, k, start, cur));
                start = cur + 1;
            }
            cur++;
        }
        return Math.max(localMax, longestSubstring(s, k, start, end));
    }

    // brute-force, TLE, tc O(n^2), sc O(1)
    public int longestSubstring1(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (check(s, i, j, k)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean check(String s, int start, int end, int k) {
        int[] dict = new int[26];
        for (int i = start; i <= end; i++) {
            dict[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (dict[i] > 0 && dict[i] < k) return false;
        }
        return true;
    }
}

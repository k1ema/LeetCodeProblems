package dynamic.WordBreak_139;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class Solution {
    // tc - O(n^3), i.e s.substring has O(n) complexity
    // sc - O(n)
    // https://leetcode.com/problems/word-break/discuss/43814/c-dynamic-programming-simple-and-fast-solution-4ms-with-optimization
    boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        Set<String> dict = new HashSet<>(wordDict);
        for (int right = 1; right <= s.length(); right++) {
            for (int left = right - 1; left >= 0; left--) {
                if (dp[left]) {
                    String sub = s.substring(left, right);
                    if (dict.contains(sub)) {
                        dp[right] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    // BFS
    // https://leetcode.com/problems/word-break/discuss/43797/A-solution-using-BFS
    // tc O(n^3), sc O(n)
    boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Set<String> dict = new HashSet<>(wordDict);
        while (!queue.isEmpty()) {
            int startInd = queue.poll();
            for (int i = startInd + 1; i <= s.length(); i++) {
                if (visited.contains(i)) {
                    continue;
                }

                String substr = s.substring(startInd, i);
                if (dict.contains(substr)) {
                    if (i == s.length()) {
                        return true;
                    }
                    queue.add(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }
}

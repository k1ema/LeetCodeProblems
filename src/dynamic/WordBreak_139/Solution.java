package dynamic.WordBreak_139;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    // https://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem
    // tc O(2^n), sc O(2^n) ?? without memoization; with memo: tc O(n^3), sc O(n)
    // i.e s.substring has O(n) complexity
    // https://stackoverflow.com/questions/4679746/time-complexity-of-javas-substring
    private Map<String, Boolean> memo;
    boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        return wordBreak(s, new HashSet<>(wordDict));
    }

    private boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.contains(s)) return true;
        if (memo.containsKey(s)) return memo.get(s);
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                String suffix = s.substring(i);
                if (wordBreak(suffix, wordDict)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }

    // tc - O(n^3)
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
    boolean wordBreak2(String s, List<String> wordDict) {
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

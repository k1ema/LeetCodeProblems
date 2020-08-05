package backtracking.WordBreak_II_140;

import java.util.*;

/**
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty
 * words, add spaces in s to construct a sentence where each word is a valid dictionary
 * word. Return all such possible sentences.
 *
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * Example 2:
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class Solution {
    // tc O(n^2 + 2^n + w), sc O(n * 2^n + w), see https://leetcode.com/articles/word-break-ii/
    // sc O(n * 2^n + w)
    // 5 ms, faster than 93.63%; 40.2 MB, less than 14.49%
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> solutions = bt(s, new HashSet<>(wordDict), new HashMap<>());

        List<String> res = new ArrayList<>();
        for (List<String> words : solutions) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (sb.length() != 0) sb.append(" ");
                sb.append(word);
            }
            res.add(sb.toString());
        }

        return res;
    }

    private List<List<String>> bt(String s, Set<String> wordDict, Map<String, List<List<String>>> memo) {
        if (s.isEmpty()) {
            List<List<String>> solutions = new ArrayList<>();
            solutions.add(new ArrayList<>());
            return solutions;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        } else {
            List<List<String>> list = new ArrayList<>();
            memo.put(s, list);
        }

        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (wordDict.contains(word)) {
                List<List<String>> list = bt(s.substring(i), wordDict, memo);
                for (List<String> words : list) {
                    List<String> res = new LinkedList<>(words);
                    res.add(0, word);
                    memo.get(s).add(res);
                }
            }
        }

        return memo.get(s);
    }

    // https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS
    public List<String> wordBreak1(String s, List<String> wordDict) {
        return bt(s, 0, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> bt(String s, int i, Set<String> wordDict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(i)) return memo.get(i);

        List<String> res = new ArrayList<>();

        if (i == s.length()) {
            res.add("");
            return res;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String word = s.substring(i, j);
            if (wordDict.contains(word)) {
                List<String> list = bt(s, j, wordDict, memo);
                for (String str : list) {
                    res.add(word + (str.isEmpty() ? "" : " " + str));
                }
            }
        }

        memo.put(i, res);
        return res;
    }
}

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
    public List<String> wordBreak(String s, List<String> wordDict) {
        return bt(s, 0, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> bt(String s, int start, Set<String> dict, Map<Integer, List<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<String> res = new ArrayList<>();

        if (start == s.length()) {
            res.add("");
            return res;
        }


        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end))) {
                List<String> list = bt(s, end, dict, map);
                for (String ss : list) {
                    res.add(s.substring(start, end) + (ss.equals("") ? "" : " ") + ss);
                }
            }
        }

        map.put(start, res);
        return res;
    }
}

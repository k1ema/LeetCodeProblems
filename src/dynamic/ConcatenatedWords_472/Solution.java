package dynamic.ConcatenatedWords_472;

import java.util.*;

/**
 * 472. Concatenated Words
 * https://leetcode.com/problems/concatenated-words/
 *
 * Given a list of words (without duplicates), please write a program that returns all concatenated
 * words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter
 * words in the given array.
 *
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 *
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 *
 * Note:
 * 1. The number of elements of the given array will not exceed 10,000
 * 2. The length sum of elements in the given array will not exceed 600,000.
 * 3. All the input string will only include lower case letters.
 * 4. The returned elements order does not matter.
 */
public class Solution {
    // 358 ms, faster than 16.30%; 45.5 MB, less than 95.24%
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;

        Arrays.sort(words, Comparator.comparingInt(String::length));

        Set<String> slovarik = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], slovarik)) {
                res.add(words[i]);
            }
            slovarik.add(words[i]);
        }
        return res;
    }

    private boolean canForm(String s, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}

package dynamic.ConcatenatedWords_472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    // 48 ms, faster than 81.15%; 44.3 MB, less than 69.43%
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>();
        for (String word : words) {
            dict.add(word);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (canForm(word, 0, false, dict, new Boolean[word.length()])) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean canForm(String word, int start, boolean splitted, Set<String> dict, Boolean[] memo) {
        if (start == word.length()) {
            return splitted;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        boolean res = false;
        for (int i = start + 1; i <= word.length(); i++) {
            String substr = word.substring(start, i);
            if (dict.contains(substr)) {
                if (canForm(word, i, splitted || i != word.length(), dict, memo)) {
                    res = true;
                    break;
                }
            }
        }
        return memo[start] = res;
    }

    // tc O(n * k^3), sc O(n)
    // 358 ms, faster than 16.30%; 45.5 MB, less than 95.24%
    public List<String> findAllConcatenatedWordsInADict1(String[] words) {
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

    // tc O(k^3) i.e s.substring has O(n) complexity
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

    // Trie
    // tc O(n * k) ?, sc O(n * k), where n - number of words, k - max word's length
    // 50 ms, faster than 84.34%; 50.2 MB, less than 26.81%
    public List<String> findAllConcatenatedWordsInADict2(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;

        TrieNode root = new TrieNode();
        for (String word : words) {
            if (word == null || word.isEmpty()) continue;
            addWord(root, word);
        }
        for (String word : words) {
            if (testWord(root, 0, word, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean testWord(TrieNode root, int ind, String word, int count) {
        TrieNode cur = root;
        for (int i = ind; i < word.length(); i++) {
            TrieNode node = cur.children[word.charAt(i) - 'a'];
            if (node == null) {
                return false;
            }
            if (node.isEnd) {
                if (i == word.length() - 1) {
                    return count >= 1;
                }
                if (testWord(root, i + 1, word, count + 1)) {
                    return true;
                }
            }
            cur = node;
        }
        return false;
    }

    private void addWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    private class TrieNode {
        boolean isEnd;
        TrieNode[] children = new TrieNode[26];
    }
}

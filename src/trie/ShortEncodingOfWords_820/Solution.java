package trie.ShortEncodingOfWords_820;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 820. Short Encoding of Words
 * https://leetcode.com/problems/short-encoding-of-words/
 *
 * A valid encoding of an array of words is any reference string s and array of indices indices such that:
 *
 * words.length == indices.length
 * The reference string s ends with the '#' character.
 * For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].
 * Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
 *
 * Example 1:
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
 * words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
 * words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
 * words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
 *
 * Example 2:
 * Input: words = ["t"]
 * Output: 2
 * Explanation: A valid encoding would be s = "t#" and indices = [0].
 *
 * Constraints:
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * words[i] consists of only lowercase letters.
 */
public class Solution {
    // tc O(sum(wi)), sc O(sum(wi)), where wi - len of word[i]
    // 16 ms, faster than 57.62%; 42.8 MB, less than 56.29%
    private int count;
    public int minimumLengthEncoding(String[] words) {
        count = 0;
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (int i = w.length() - 1; i >= 0; i--) {
                int ind = w.charAt(i) - 'a';
                if (cur.children[ind] == null) {
                    cur.children[ind] = new TrieNode();
                }
                cur = cur.children[ind];
            }
        }

        dfs(root, 0);
        return count;
    }

    private void dfs(TrieNode root, int parentPath) {
        boolean noChildren = true;
        for (TrieNode node : root.children) {
            if (node != null) {
                noChildren = false;
                dfs(node, parentPath + 1);
            }
        }
        if (noChildren) {
            count += parentPath + 1;
        }
    }

    private static class TrieNode {
        private TrieNode[] children;
        private TrieNode() {
            children = new TrieNode[26];
        }
    }

    // another solution
    public int minimumLengthEncoding1(String[] words) {
        TrieNode1 root = new TrieNode1();
        Set<TrieNode1> leaves = new HashSet<>();
        for (String w : words) {
            TrieNode1 cur = root;
            for (int i = w.length() - 1; i >= 0; i--) {
                char c = w.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode1());
                }
                cur = cur.children.get(c);
            }
            cur.depth = w.length() + 1;
            leaves.add(cur);
        }

        int count = 0;
        for (TrieNode1 node : leaves) {
            if (node.children.isEmpty()) {
                count += node.depth;
            }
        }
        return count;
    }

    private static class TrieNode1 {
        private final Map<Character, TrieNode1> children = new HashMap<>();
        private int depth;

        private TrieNode1() {
        }
    }

    // tc O(n*k*k), sc O(n*k) where n = words.length, k = max word len
    // 29 ms, faster than 29.80%; 51.8 MB, less than 15.23%
    public int minimumLengthEncoding2(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String w : words) {
            for (int i = 1; i < w.length(); i++) {
                set.remove(w.substring(i));
            }
        }
        return set.stream().mapToInt(s -> s.length() + 1).sum();
    }
}

package design.ImplementTrie_208;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */

// Good solution with array of TrieNode instead of hashtable.
// https://leetcode.com/problems/implement-trie-prefix-tree/discuss/58832/AC-JAVA-solution-simple-using-single-array
public class Trie {
    private class TrieNode {
        char val;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();

        private TrieNode() {}

        private TrieNode(char val) {
            this.val = val;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    // tc O(word.len)
    public void insert(String word) {
        int i = 0;
        TrieNode node = root;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node = node.children.get(c);
            i++;
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    // tc O(word.len)
    public boolean search(String word) {
        int i = 0;
        TrieNode node = root;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
                i++;
            } else {
                return false;
            }
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    // tc O(prefix.len)
    public boolean startsWith(String prefix) {
        int i = 0;
        TrieNode node = root;
        while (i < prefix.length()) {
            char c = prefix.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}

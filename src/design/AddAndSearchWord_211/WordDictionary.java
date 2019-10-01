package design.AddAndSearchWord_211;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Add and Search Word - Data structure design
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
// 105 ms, faster than 17.38%; 53.7 MB, less than 93.94%
public class WordDictionary {
    private class TrieNode {
        char val;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {}

        public TrieNode(char val) {
            this.val = val;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    // tc O(n)
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    // tc O(n^2) in worst case when word consists from dots
    public boolean search(String word) {
        TrieNode node = root;
        return search(word, 0, node);
    }

    private boolean search(String word, int ind, TrieNode node) {
        if (ind >= word.length()) return node.isWord;
        char c = word.charAt(ind);
        if (c != '.') {
            return node.children.containsKey(c) && search(word, ind + 1, node.children.get(c));
        } else {
            boolean result = false;
            for (TrieNode child : node.children.values()) {
                result |= search(word, ind + 1, child);
            }
            return result;
        }
    }
}

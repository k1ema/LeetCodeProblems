package design.AddAndSearchWord_211;

import java.util.HashMap;
import java.util.Map;

// 105 ms, faster than 17.38%; 53.7 MB, less than 93.94%
public class WordDictionary_Map {
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
    public WordDictionary_Map() {
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
    // tc O(26^n) in worst case when word consists from dots. Where n - word length
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

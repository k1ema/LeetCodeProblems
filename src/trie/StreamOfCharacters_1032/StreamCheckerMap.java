package trie.StreamOfCharacters_1032;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class StreamCheckerMap {
    // 198 ms, faster than 36.25%; 166.2 MB, less than 9.41%
    private class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean word;
    }

    private TrieNode root;
    private Deque<Character> stream;

    // tc O(mn), where m - number of words, n - max word length; sc O(mn)
    public StreamCheckerMap(String[] words) {
        root = new TrieNode();
        stream = new ArrayDeque<>();

        for (String word : words) {
            char[] w = word.toCharArray();
            TrieNode trie = root;
            for (int i = w.length - 1; i >= 0; i--) {
                if (!trie.children.containsKey(w[i])) {
                    trie.children.put(w[i], new TrieNode());
                }
                trie = trie.children.get(w[i]);
            }
            trie.word = true;
        }
    }

    // tc O(n), where n is a max word length
    public boolean query(char letter) {
        stream.addFirst(letter);
        TrieNode trie = root;
        for (char c : stream) {
            if (trie.word) return true;
            if (!trie.children.containsKey(c)) return false;
            trie = trie.children.get(c);
        }
        return trie.word;
    }
}

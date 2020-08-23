package trie.StreamOfCharacters_1032;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1032. Stream of Characters
 * https://leetcode.com/problems/stream-of-characters/
 *
 * Implement the StreamChecker class as follows:
 *
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters
 * queried (in order from oldest to newest, including this letter just queried) spell
 * one of the words in the given list.
 *
 * Example:
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 *
 * Note:
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000.
 */
public class StreamChecker {
    private TrieNode root;
    private Deque<Character> stream;

    // 89 ms, faster than 81.24%; 69.1 MB, less than 92.22%
    // tc O(mn), where m - number of words, n - max word length; sc O(mn)
    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new ArrayDeque<>();
        for (String word : words) {
            TrieNode trie = root;
            char[] w = word.toCharArray();
            for (int i = w.length - 1; i >= 0; i--) {
                int ind = w[i] - 'a';
                if (trie.children[ind] == null ) {
                    trie.children[ind] = new TrieNode(w[i]);
                }
                trie = trie.children[ind];
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
            if (trie.children[c - 'a'] == null) return false;
            trie = trie.children[c - 'a'];
        }
        return trie.word;
    }

    private class TrieNode {
        private char c;
        private TrieNode[] children;
        private boolean word;

        TrieNode() {
            children = new TrieNode[26];
        }

        TrieNode(char c) {
            this();
            this.c = c;
        }
    }
}

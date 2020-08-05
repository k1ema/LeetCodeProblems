package design.AddAndSearchWord_211;

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
// 80 ms, faster than 32.03%; 77.9 MB, less than 5.27%
public class WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    // tc O(n)
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int ind = c - 'a';
            if (cur.children[ind] == null) {
                cur.children[ind] = new TrieNode();
            }
            cur = cur.children[ind];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    // tc O(26^n) in worst case when word consists from dots. Where n - word length
    public boolean search(String word) {
        TrieNode cur = root;
        return search(word, 0, cur);
    }

    private boolean search(String word, int j, TrieNode node) {
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            int ind = c - 'a';
            if (c == '.') {
                for (int k = 0; k < 26; k++) {
                    if (node.children[k] == null) continue;
                    if (search(word, i + 1, node.children[k])) return true;
                }
                return false;
            } else {
                if (node.children[ind] == null) {
                    return false;
                } else {
                    node = node.children[ind];
                }
            }
        }
        return node.isWord;
    }

    private class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
}

package trie.WordSquares_425;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 425. Word Squares
 * https://leetcode.com/problems/word-squares/
 *
 * Given a set of words (without duplicates), find all word squares you can build from them.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact
 * same string, where 0 ≤ k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because
 * each word reads the same both horizontally and vertically.
 *
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 *
 * Note:
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 *
 * Example 1:
 *
 * Input:
 * ["area","lead","wall","lady","ball"]
 *
 * Output:
 * [
 *   [ "wall",
 *     "area",
 *     "lead",
 *     "lady"
 *   ],
 *   [ "ball",
 *     "area",
 *     "lead",
 *     "lady"
 *   ]
 * ]
 *
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the
 * order of words in each word square matters).
 *
 * Example 2:
 *
 * Input:
 * ["abat","baba","atan","atal"]
 *
 * Output:
 * [
 *   [ "baba",
 *     "abat",
 *     "baba",
 *     "atan"
 *   ],
 *   [ "baba",
 *     "abat",
 *     "baba",
 *     "atal"
 *   ]
 * ]
 *
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the
 * order of words in each word square matters).
 */
public class Solution {
    // tc O(N * 26^L * L) in worst case, where N - words.length, L = word.length
    // sc O(N * L)
    // 69 ms, faster than 43.75%; 41.9 MB, less than 92.27%
    public List<List<String>> wordSquares(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode trie = root;
            for (char c : word.toCharArray()) {
                int ind = c - 'a';
                if (trie.children[ind] == null) {
                    trie.children[ind] = new TrieNode();
                }
                trie = trie.children[ind];
            }
            trie.word = word;
        }

        List<List<String>> res = new ArrayList<>();
        bt(words, root, "", new ArrayList<>(), res);
        return res;
    }

    private void bt(String[] words, TrieNode root, String prefix, List<String> square, List<List<String>> res) {
        if (square.size() == words[0].length()) {
            res.add(new ArrayList<>(square));
            return;
        }
        for (String word : search(root, prefix)) {
            square.add(word);
            StringBuilder sb = new StringBuilder();
            if (square.size() < word.length()) {
                for (String w : square) {
                    sb.append(w.charAt(square.size()));
                }
            }
            bt(words, root, sb.toString(), square, res);
            square.remove(square.size() - 1);
        }
    }

    private class TrieNode {
        private TrieNode[] children;
        private String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private List<String> search(TrieNode root, String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode trie = root;
        for (char c : prefix.toCharArray()) {
            if (trie.children[c - 'a'] == null) return res;
            trie = trie.children[c - 'a'];
        }
        dfs(trie, res);
        return res;
    }

    private void dfs(TrieNode root, List<String> res) {
        if (root.word != null) {
            res.add(root.word);
            return;
        }
        for (TrieNode child : root.children) {
            if (child != null) dfs(child, res);
        }
    }

    /*
        ["area","lead","wall","lady","ball"]
        b a l l
        a r e a
        l e a d
        l a d y
    */
    // TLE, tc O(C(M,N)*N), sc O(?), where M - words.length, N - word.length
    public List<List<String>> wordSquares1(String[] words) {
        Set<List<String>> res = new HashSet<>();
        bt(words, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    private void bt(String[] words, List<String> square, Set<List<String>> res) {
        if (square.size() == words[0].length()) {
            // System.out.println(tmp);
            if (checkSquare(square)) {
                res.add(new ArrayList<>(square));
            }
            return;
        }
        for (String word : words) {
            if (checkWord(word, square)) {
                square.add(word);
                bt(words, square, res);
                square.remove(square.size() - 1);
            }
        }
    }

    private boolean checkWord(String word, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (word.charAt(i) != list.get(i).charAt(size)) return false;
        }
        return true;
    }

    private boolean checkSquare(List<String> words) {
        if (words == null || words.isEmpty()) return false;
        int len = words.size();
        for (int i = 0; i < len; i++) {
            String word = words.get(i);
            if (word.length() != len) return false;
            StringBuilder vertical = new StringBuilder();
            for (String s : words) {
                vertical.append(s.charAt(i));
            }
            if (!word.equals(vertical.toString())) return false;
        }
        return true;
    }
}

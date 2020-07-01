package trie.WordSearch_II_212;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring. The same letter cell may not be
 * used more than once in a word.
 *
 * Example:
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 * Note:
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */
// https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
// 9 ms, faster than 94.45%, 47.6 MB, less than 51.11%
public class Solution_I implements Solution {
    // tc O(m * n * 4 * 3 ^ (L - 1)), where m,n - dimensions in board, L - the max length of string in words
    // sc O(m * n)

    private class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    bt(result, root, board, i, j);
                }
            }
        }

        return result;
    }

    private void bt(List<String> result, TrieNode node, char[][] board, int i, int j) {
        char c = board[i][j];
        if (c == '*' || node.children[c - 'a'] == null) return;

        TrieNode currNode = node.children[c - 'a'];
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        board[i][j] = '*';
        if (i > 0) bt(result, currNode, board, i - 1, j);
        if (j > 0) bt(result, currNode, board, i, j - 1);
        if (i < board.length - 1) bt(result, currNode, board, i + 1, j);
        if (j < board[0].length - 1) bt(result, currNode, board, i, j + 1);
        board[i][j] = c;
    }
}

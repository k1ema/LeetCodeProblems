package trie.WordSearch_II_212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
// 20 ms
public class SolutionHashMap implements Solution {
    private class TrieNode {
        private String word;
        private Map<Character, TrieNode> children = new HashMap<>();
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.word = word;
        }

        // Start backtracking for each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    bt(root, board, i, j, result);
                }
            }
        }

        return result;
    }

    private void bt(TrieNode root, char[][] board, int row, int col, List<String> result) {
        char c = board[row][col];
        TrieNode node = root.children.get(c);
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        // mark cell as visited
        board[row][col] = '*';

        int[] rowOffset = new int[] {1, 0, -1, 0};
        int[] colOffset = new int[] {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newCol < 0 || newRow == board.length || newCol == board[0].length) {
                continue;
            }
            if (node.children.containsKey(board[newRow][newCol])) {
                bt(node, board, newRow, newCol, result);
            }
        }

        // revert cell
        board[row][col] = c;

        // Optimization: incrementally remove the leaf nodes
        if (node.children.isEmpty()) {
            root.children.remove(c);
        }
    }
}

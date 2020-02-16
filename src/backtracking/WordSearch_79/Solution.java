package backtracking.WordSearch_79;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring. The same letter cell may not be
 * used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class Solution {
    // tc O((n*m)^2) because for each cell we can do whole board traversal, sc O(1)
    // 5 ms, faster than 65.90%; 43.3 MB, less than 19.39%
    boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (bt(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bt(char[][] board, String word, int row, int col, int ind) {
        if (ind == word.length()) return true;
        if (row < 0 || col < 0 || row == board.length || col == board[0].length
                || board[row][col] != word.charAt(ind)) return false;
        // mark cell as visited
        board[row][col] = '*';
        boolean res = bt(board, word, row + 1, col, ind + 1)
                || bt(board, word, row - 1, col, ind + 1)
                || bt(board, word, row, col + 1, ind + 1)
                || bt(board, word, row, col - 1, ind + 1);
        // revert cell
        board[row][col] = word.charAt(ind);
        return res;
    }
}

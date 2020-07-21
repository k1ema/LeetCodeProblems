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
    // tc O(N*4^L), where N - is the number of cells in the board, L - the length of the word
    // sc O(L): The maximum length of the call stack would be the length of the word
    // 15 ms, 52.2 MB
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (bt(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean bt(char[][] board, String word, int i, int j, int wordInd) {
        if (wordInd == word.length()) return true;
        if (i < 0 || i == board.length || j < 0 || j == board[i].length || board[i][j] != word.charAt(wordInd)) return false;
        board[i][j] = '*';
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            if (bt(board, word, i + dir[0], j + dir[1], wordInd + 1)) return true;
        }
        board[i][j] = word.charAt(wordInd);
        return false;
    }
}

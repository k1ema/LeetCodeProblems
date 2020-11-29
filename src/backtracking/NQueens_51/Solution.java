package backtracking.NQueens_51;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 * Example 1:
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 *
 * Example 2:
 * Input: n = 1
 * Output: [["Q"]]
 *
 * Constraints:
 * 1 <= n <= 9
 */
public class Solution {
    // 62 ms, faster than 5.12%; 39.4 MB, less than 39.72%
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        bt(new boolean[n][n], 0, new ArrayList<>(), res);
        return res;
    }

    private void bt(boolean[][] board, int row, List<String> list, List<List<String>> res) {
        if (row == board.length) {
            if (!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        int n = board.length;
        for (int i = 0; i < n; i++) {
            boolean[][] copyBoard = new boolean[n][n];
            makeDeepCopy(board, copyBoard);
            if (putQueen(board, row, i)) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(j == i ? "Q" : ".");
                }
                list.add(sb.toString());
                bt(board, row + 1, list, res);
                list.remove(list.size() - 1);
            }
            makeDeepCopy(copyBoard, board);
        }
    }

    private boolean putQueen(boolean[][] board, int i, int j) {
        if (board[i][j]) return false;
        for (int row = 0; row < board.length; row++) {
            board[row][j] = true;
        }
        for (int col = 0; col < board[i].length; col++) {
            board[i][col] = true;
        }
        int di = i, dj = j;
        while (--di >= 0 && --dj >= 0) {
            board[di][dj] = true;
        }
        di = i; dj = j;
        while (++di < board.length && ++dj < board[i].length) {
            board[di][dj] = true;
        }
        di = i; dj = j;
        while (--di >= 0 && ++dj < board[i].length) {
            board[di][dj] = true;
        }
        di = i; dj = j;
        while (++di < board.length && --dj >= 0) {
            board[di][dj] = true;
        }

        return true;
    }

    private void makeDeepCopy(boolean[][] from, boolean[][] to) {
        int n = from.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                to[r][c] = from[r][c];
            }
        }
    }
}

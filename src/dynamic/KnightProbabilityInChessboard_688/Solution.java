package dynamic.KnightProbabilityInChessboard_688;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 688. Knight Probability in Chessboard
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 *
 * On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows
 * and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
 *
 * A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal
 * direction, then one cell in an orthogonal direction.
 *
 *
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece
 * would go off the chessboard) and moves there.
 *
 * The knight continues moving until it has made exactly k moves or has moved off the chessboard.
 *
 * Return the probability that the knight remains on the board after it has stopped moving.
 *
 * Example 1:
 * Input: n = 3, k = 2, row = 0, column = 0
 * Output: 0.06250
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 *
 * Example 2:
 * Input: n = 1, k = 0, row = 0, column = 0
 * Output: 1.00000
 *
 * Constraints:
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n
 */
public class Solution {
    // tc O(k), sc O(k * n^2); without memo tc = O(8^k)
    // 7 ms, faster than 40.62%; 40.3 MB, less than 10.30%
    public double knightProbability1(int n, int k, int row, int column) {
        return helper(n, k, row, column, new Double[n][n][k + 1]);
    }

    private double helper(int n, int k, int i, int j, Double[][][] memo) {
        if (k == 0) return 1d;
        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }
        double res = 0;
        int[][] dirs = new int[][] {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < n) {
                res += 0.125d * helper(n, k - 1, newI, newJ, memo);
            }
        }
        return memo[i][j][k] = res;
    }

    // BFS
    // 9 ms, faster than 24.64%; 38.2 MB, less than 66.41%
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) return 1;
        int[][] dirs = new int[][] {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        double[][] map = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 1);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {row, column});

        int level = 0;
        while (!q.isEmpty() && level++ < k) {
            int size = q.size();
            double[][] tmp = new double[n][n];
            while (size-- > 0) {
                int[] coord = q.poll();
                int i = coord[0], j = coord[1];
                for (int[] dir : dirs) {
                    int newI = i + dir[0], newJ = j + dir[1];
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < n) {
                        if (tmp[newI][newJ] == 0) {
                            q.add(new int[] {newI, newJ});
                        }
                        tmp[newI][newJ] += map[i][j];
                    }
                }
            }
            map = tmp;
        }
        double validMoves = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                validMoves += map[i][j];
            }
        }
        return validMoves / Math.pow(8, k);
    }
}
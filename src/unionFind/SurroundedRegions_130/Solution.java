package unionFind.SurroundedRegions_130;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the
 * board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an
 * 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells
 * connected horizontally or vertically.
 */
public class Solution {
    // DFS: 1 ms, faster than 100.00%; 40.1 MB, less than 96.43%
    // https://leetcode.com/problems/surrounded-regions/discuss/41612/A-really-simple-and-readable-C%2B%2B-solutionuff0conly-cost-12ms
    // First, check the four border of the matrix. If there is a element is 'O', alter it and all its neighbor 'O' elements to '1'.
    // Then ,alter all the 'O' to 'X'
    // At last,alter all the '1' to 'O'
    // For example:
    // X X X X           X X X X             X X X X
    // X X O X  ->       X X O X    ->       X X X X
    // X O X X           X 1 X X             X O X X
    // X O X X           X 1 X X             X O X X
    void solve(char[][] board) {
        int n;
        if (board == null || (n = board.length) == 0) return;
        int m = board[0].length;
        for (int j = 0; j < m; j++) {
            dfs(board, 0, j, n, m);
            if (n > 1) dfs(board, n - 1, j, n, m);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0, n, m);
            if (m > 1) dfs(board, i, m - 1, n, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int n, int m) {
        if (board[i][j] == 'X' || board[i][j] == '1') return;
        board[i][j] = '1';
        if (i > 0) dfs(board, i - 1, j, n, m);
        if (j > 0) dfs(board, i, j - 1, n, m);
        if (i < n - 1) dfs(board, i + 1, j, n, m);
        if (j < m - 1) dfs(board, i, j + 1, n, m);
    }

    // Union-find: 4 ms, faster than 20.75%; 47.3 MB, less than 10.71%
    // https://leetcode.com/problems/surrounded-regions/discuss/41617/Solve-it-using-Union-Find
    private int[] id;
    private int[] rank;
    void solve1(char[][] board) {
        int n;
        if (board == null || (n = board.length) == 0) return;
        int m = board[0].length;
        id = new int[n * m + 1];
        rank = new int[n * m + 1];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') continue;
                int ind = i * m + j;
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    union(ind, m * n);
                } else {
                    if (board[i - 1][j] == 'O') {
                        union(ind, (i - 1) * m + j);
                    }
                    if (board[i][j - 1] == 'O') {
                        union(ind, i * m + j - 1);
                    }
                    if (board[i + 1][j] == 'O') {
                        union(ind, (i + 1) * m + j);
                    }
                    if (board[i][j + 1] == 'O') {
                        union(ind, i * m + j + 1);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (connected(i * m + j, n * m)) continue;
                board[i][j] = 'X';
            }
        }
    }

    private int root(int x) {
        while (id[x] != x) {
            id[x] = id[id[x]]; // path compression
            x = id[x];
        }
        return x;
    }

    private void union(int i, int j) {
        int pi = root(i);
        int pj = root(j);
        if (pi == pj) return;
        if (rank[pi] < rank[pj]) {
            id[pi] = pj; rank[pj] += rank[pi];
        } else {
            id[pj] = pi; rank[pi] += rank[pj];
        }
    }

    private boolean connected(int i, int j) {
        return root(i) == root(j);
    }
}

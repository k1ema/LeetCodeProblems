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
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            if (n > 1) dfs(board, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, m, n);
            if (m > 1) dfs(board, m - 1, j, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }

    private int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i == m || j < 0 || j == n || board[i][j] != 'O') return;
        board[i][j] = '1';
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1], m, n);
        }
    }

    // Union-find: 4 ms, faster than 20.75%; 47.3 MB, less than 10.71%
    // https://leetcode.com/problems/surrounded-regions/discuss/41617/Solve-it-using-Union-Find
    private int[] id;
    private int[] rank;
    void solve1(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        id = new int[m * n + 1];
        rank = new int[m * n + 1];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') continue;
                int ind = i * n + j;
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    union(ind, n * m);
                } else {
                    int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
                    for (int[] dir : dirs) {
                        int newI = i + dir[0], newJ = j + dir[1];
                        if (board[newI][newJ] == 'O') union(ind, newI * n + newJ);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (connected(i * n + j, m * n)) continue;
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

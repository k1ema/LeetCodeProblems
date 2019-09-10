package unionFind.NumberOfIslands_200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded
 * by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four
 * edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */
public class Solution {
    // Good solution
    // https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
    // dfs, tc O(n * m), sc O(n * m)
    // 1 ms, faster than 100.00%, 41.3 MB, less than 58.61%
    int numIslands(char[][] grid) {
        int n;
        if (grid == null || (n = grid.length) == 0) return 0;
        int count = 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    destroyIsland(grid, i, j, n, m);
                    count++;
                }

            }
        }
        return count;
    }

    private void destroyIsland(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;
        grid[i][j] = '0';
        destroyIsland(grid, i + 1, j, n, m);
        destroyIsland(grid, i - 1, j, n, m);
        destroyIsland(grid, i, j + 1, n, m);
        destroyIsland(grid, i, j - 1, n, m);
    }

    // Union-find
    // https://leetcode.com/problems/number-of-islands/discuss/56354/1D-Union-Find-Java-solution-easily-generalized-to-other-problems
    // 5 ms, faster than 14.80%, 40.7 MB, less than 98.60%
    // tc O(n * m * log(n * m)) ?, n * m - double array; for each i,j - find, which costs log(n*m)
    // sc O(n * m)
    private int[] id;
    private int[] sz; // for weighted union-find
    int numIslands1(char[][] grid) {
        int n;
        if (grid == null || (n = grid.length) == 0) return 0;

        int m = grid[0].length;
        id = new int[n * m];
        sz = new int[n * m];
        Arrays.fill(id, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') continue;
                int ind = i * m + j;
                id[ind] = ind; // note, that id was filled witn -1 values
                if (i > 0 && grid[i - 1][j] == '1') union(ind, (i - 1) * m + j); // union current + top
                if (j > 0 && grid[i][j - 1] == '1') union(ind, i * m + j - 1); // union current + left
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < id.length; i++) {
            if (id[i] > -1) set.add(find(id[i]));
        }
        return set.size();
    }

    // tc O(log(n * m)))
    private int find(int x) {
        while (id[x] != x) {
            id[x] = id[id[x]]; // path compression
            x = id[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else { id[j] = i; sz[i] += sz[j]; }
    }

    // without weighted
    private void union1(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i == j) return;
        id[i] = j;
    }
}

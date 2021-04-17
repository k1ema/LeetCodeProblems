package mst.SwimInRisingWater_778;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 778. Swim in Rising Water
 * https://leetcode.com/problems/swim-in-rising-water/
 *
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 *
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to
 * another 4-directionally adjacent square if and only if the elevation of both squares individually are at
 * most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the
 * grid during your swim.
 *
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?
 *
 * Example 1:
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 *
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 *
 * Example 2:
 * Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 *  0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 *
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 *
 * Note:
 * 2 <= N <= 50.
 * grid[i][j] is a permutation of [0, ..., N*N - 1].
 */
public class Solution {
    // union-find
    // tc O(n^2*logn), sc O(n^2)
    // 4 ms, faster than 87.89%; 39.1 MB, less than 49.86%
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);

        int[] map = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[grid[i][j]] = i * n + j;
            }
        }

        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int time = 0; time < map.length; time++) {
            int idx = map[time];
            int i = idx / n;
            int j = idx % n;

            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && grid[newI][newJ] <= time) {
                    uf.union(idx, newI * n + newJ);
                }
            }
            if (uf.connected(0, n * n - 1)) {
                return time;
            }
        }

        return -1;
    }

    // classic Kruskal
    public int swimInWater3(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q.offer(new int[] {i, j, grid[i][j]});
            }
        }

        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int time = 0;
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int i = arr[0], j = arr[1];

            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && grid[newI][newJ] <= time) {
                    int idx1 = i * n + j, idx2 = newI * n + newJ;
                    uf.union(idx1, idx2);
                }
            }
            if (uf.connected(0, n * n - 1)) {
                return time;
            }
            time++;
        }

        return -1;
    }

    private static class UnionFind {
        private int[] id;
        private int[] sz;

        UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x == p_y) return;
            if (sz[p_x] < sz[p_y]) {
                id[p_x] = p_y;
                sz[p_y] += sz[p_x];
            } else {
                id[p_y] = p_x;
                sz[p_x] += sz[p_y];
            }

        }

        int find(int x) {
            while (id[x] != x) {
                id[x] = id[id[x]];
                x = id[x];
            }
            return x;
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    // binary search, bfs
    // tc O(n^2*logn), sc O(n^2)
    // 6 ms, faster than 82.26%; 39 MB, less than 54.65%
    public int swimInWater1(int[][] grid) {
        int n = grid.length;
        int l = -1, r = n * n - 1;
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (canReach(grid, m)) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    private boolean canReach(int[][] grid, int depth) {
        if (grid[0][0] > depth) return false;
        int n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!q.isEmpty()) {
            int[] coord = q.poll();
            int x = coord[0], y = coord[1];
            if (x == n - 1 && y == n - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] <= depth) {
                    q.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    // binary search, dfs
    // tc O(n^2*logn), sc O(n^2)
    // 6 ms, faster than 82.34%; 39.5 MB, less than 26.27%
    public int swimInWater2(int[][] grid) {
        int n = grid.length;
        int l = -1, r = n * n - 1;
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (dfs(grid, 0, 0, n, m, new boolean[n][n])) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    private boolean dfs(int[][] grid, int i, int j, int n, int target, boolean[][] visited) {
        if (grid[i][j] > target) return false;
        if (i == n - 1 && j == n - 1) return true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && !visited[newI][newJ] && grid[newI][newJ] <= target) {
                if (dfs(grid, newI, newJ, n, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}

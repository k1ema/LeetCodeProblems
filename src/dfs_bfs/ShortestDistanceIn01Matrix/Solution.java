package dfs_bfs.ShortestDistanceIn01Matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1. Given a 2D matrix which contains 0,1 values mark as 'b' all border 1s
 * 2. Find distance for all 1s to the nearest border
 */
public class Solution {
    public void markBorders(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        matrix[i][j] = 'b';
                    } else {
                        boolean isBorder = false;
                        for (int[] dir : dirs) {
                            int newI = i + dir[0], newJ = j + dir[1];
                            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] == '0') {
                                isBorder = true;
                                break;
                            }
                        }
                        if (isBorder) {
                            matrix[i][j] = 'b';
                        }
                    }
                }
            }
        }
    }

    public int[][] calcShortestDistance(char[][] matrix) {
        final int MAX = (int) 1e9;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        int[][] distances = new int[m][n];
        for (int[] dist : distances) {
            Arrays.fill(dist, MAX);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'b') {
                    q.add(new int[] {i, j});
                    distances[i][j] = 0;
                } else if (matrix[i][j] == '0') {
                    distances[i][j] = 0;
                }
            }
        }

        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] == '1' && (distances[i][j] + 1 < distances[newI][newJ])) {
                    q.add(new int[] {newI, newJ});
                    distances[newI][newJ] = distances[i][j] + 1;
                }
            }
        }

        return distances;
    }

    // Dijkstra
    public int[][] calcShortestDistance1(char[][] matrix) {
        final int MAX = (int) 1e9;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] distances = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int[] dist : distances) {
            Arrays.fill(dist, MAX);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'b') {
                    pq.add(new int[] {i, j, 0});
                } else if (matrix[i][j] == '0') {
                    distances[i][j] = 0;
                }
            }
        }

        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0], j = p[1], dist = p[2];
            if (visited[i][j]) continue;
            distances[i][j] = dist;
            visited[i][j] = true;
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] == '1' && (dist + 1 < distances[newI][newJ]) && !visited[newI][newJ]) {
                    pq.add(new int[] {newI, newJ, dist + 1});
                }
            }
        }
        return distances;
    }
}

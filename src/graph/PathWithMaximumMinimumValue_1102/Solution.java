package graph.PathWithMaximumMinimumValue_1102;

import java.util.PriorityQueue;

/**
 * 1102. Path With Maximum Minimum Value
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 *
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path
 * starting at [0,0] and ending at [R-1,C-1].
 *
 * The score of a path is the minimum value in that path.  For example, the value of the path
 * 8 →  4 →  5 →  9 is 4.
 *
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell
 * in one of the 4 cardinal directions (north, east, west, south).
 *
 * Example 1:
 * 5 4 5
 * 1 2 6
 * 7 4 6
 *
 * Input: [[5,4,5],[1,2,6],[7,4,6]]
 * Output: 4
 *
 * Explanation:
 * The path with the maximum score is highlighted in yellow.
 *
 * Example 2:
 * 2 2 1 2 2 2
 * 1 2 2 2 1 2
 *
 * Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * Output: 2
 *
 * Example 3:
 * 3 4 6 3 4
 * 0 2 1 1 7
 * 8 8 3 2 7
 * 3 2 4 9 8
 * 4 1 2 0 0
 * 4 6 5 4 3
 *
 * Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * Output: 3
 *
 * Note:
 * 1 <= R, C <= 100
 * 0 <= A[i][j] <= 10^9
 */
public class Solution {
    // BFS, tc O(nm), sc O(1)
    // 82 ms, faster than 70.77%; 42.1 MB, less than 100.00%
    public int maximumMinimumPath(int[][] A) {
        int[][] DIR = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[] {A[0][0], 0, 0});
        int n = A.length, m = A[0].length, min = A[0][0];
        A[0][0] = -1;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int i = poll[1], j = poll[2];
            min = Math.min(min, poll[0]);
            if (i == n - 1 && j == m - 1) break;
            for (int[] dir : DIR) {
                int newi = i + dir[0], newj = j + dir[1];
                if (newi >= 0 && newi < n && newj >= 0 && newj < m && A[newi][newj] >= 0) {
                    pq.add(new int[] {A[newi][newj], newi, newj});
                    A[newi][newj] = -1;
                }
            }
        }
        return min;
    }
}

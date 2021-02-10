package hashtable.NumberOfDistinct_Islands_II_711;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 711. Number of Distinct Islands II
 * https://leetcode.com/problems/number-of-distinct-islands-ii/
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same
 * as another if they have the same shape, or have the same shape after rotation
 * (90, 180, or 270 degrees only) or reflection (left/right direction or up/down direction).
 *
 * Example 1:
 * 11000
 * 10000
 * 00001
 * 00011
 * Given the above grid map, return 1.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered same island shapes. Because if we make a 180 degrees clockwise
 * rotation on the first island, then two islands will have the same shapes.
 *
 * Example 2:
 * 11100
 * 10001
 * 01001
 * 01110
 * Given the above grid map, return 2.
 *
 * Here are the two distinct islands:
 * 111
 * 1
 * and
 * 1
 * 1
 *
 * Notice that:
 * 111
 * 1
 * and
 * 1
 * 111
 * are considered same island shapes. Because if we flip the first array in
 * the up/down direction, then they have the same shapes.
 *
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Solution {
    // tc O(m * n * log (m * n)), sc O(m * n)
    // 66 ms, faster than 43.18%; 40.6 MB, less than 100.00%
    public int numDistinctIslands2(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(grid, i, j, shape);
                    islands.add(norm(shape));
                }
            }
        }
        return islands.size();
    }

    private void dfs(int[][] grid, int i, int j, List<int[]> shape) {
        grid[i][j] = 0;
        int m = grid.length, n = grid[0].length;
        shape.add(new int[] {i, j});
        int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1) {
                dfs(grid, newI, newJ, shape);
            }
        }
    }

    private String norm(List<int[]> shape) {
        List<String> forms = new ArrayList<>();
        int[][] trans = new int[][] {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        for (int[] tr : trans) {
            List<int[]> list1 = new ArrayList<>();
            List<int[]> list2 = new ArrayList<>();
            for (int[] sh : shape) {
                list1.add(new int[] {sh[0] * tr[0], sh[1] * tr[1]});
                list2.add(new int[] {sh[1] * tr[1], sh[0] * tr[0]});
            }
            forms.add(getKey(list1));
            forms.add(getKey(list2));
        }
        Collections.sort(forms);
        return forms.get(0);
    }

    private String getKey(List<int[]> list) {
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int[] coord : list) {
            sb.append(coord[0] - list.get(0)[0]).append(":").append(coord[1] - list.get(0)[1]).append(":");
        }
        return sb.toString();
    }
}

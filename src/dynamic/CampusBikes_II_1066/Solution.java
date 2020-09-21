package dynamic.CampusBikes_II_1066;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1066. Campus Bikes II
 * https://leetcode.com/problems/campus-bikes-ii/
 *
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M.
 * Each worker and bike is a 2D coordinate on this grid.
 *
 * We assign one unique bike to each worker so that the sum of the Manhattan distances
 * between each worker and their assigned bike is minimized.
 *
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 *
 * Return the minimum possible sum of Manhattan distances between each worker and their
 * assigned bike.
 *
 * Example 1:
 * |              0
 * |    0
 * |         x
 * |
 * x----------------
 * 0    1    2    3
 *
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: 6
 * Explanation:
 * We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of both
 * assignments is 3, so the output is 6.
 *
 * Example 2:
 * Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * Output: 4
 * Explanation:
 * We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker 2,
 * bike 2 to worker 2 or worker 1. Both assignments lead to sum of the Manhattan
 * distances as 4.
 *
 * Note:
 * 0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
 * All worker and bike locations are distinct.
 * 1 <= workers.length <= bikes.length <= 10
 */
public class Solution {
    // BFS
    // 35 ms, faster than 53.94%; 39.7 MB, less than 15.60%
    public int assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Node(0, 0, 0));
        Set<String> seen = new HashSet<>();
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            String key = "$" + cur.worker + "$" + cur.mask;
            if (seen.contains(key)) continue;
            seen.add(key);
            if (cur.worker == workers.length) return cur.dist;

            for (int i = 0; i < bikes.length; i++) {
                if ((cur.mask & (1 << i)) == 0) {
                    pq.add(new Node(cur.worker + 1, cur.mask | (1 << i),
                            cur.dist + distance(workers[cur.worker], bikes[i])));
                }
            }
        }
        return -1;
    }

    private class Node {
        int worker;
        int mask;
        int dist;

        public Node(int worker, int mask, int dist) {
            this.worker = worker;
            this.mask = mask;
            this.dist = dist;
        }
    }

    // tc O(M!/(M - N)!)
    // sc O(MN + M), where MN - allPairs, M - recursion depth
    // 652ms
    public int assignBikes1(int[][] workers, int[][] bikes) {
        return dfs(workers, 0, bikes, new boolean[bikes.length]);
    }

    private int dfs(int[][] workers, int idx, int[][] bikes, boolean[] used) {
        if (idx == workers.length) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            int cur_dist = distance(workers[idx], bikes[i]) + dfs(workers, idx + 1, bikes, used);
            res = Math.min(res, cur_dist);
            used[i] = false;
        }
        return res;
    }

    private int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    // 364 ms
    // DFS with early exit
    int res;
    public int assignBikes2(int[][] workers, int[][] bikes) {
        res = Integer.MAX_VALUE;
        dfs(workers, 0, bikes, new boolean[bikes.length], 0);
        return res;
    }

    private void dfs(int[][] workers, int idx, int[][] bikes, boolean[] used, int sum) {
        if (idx == workers.length) {
            res = Math.min(res, sum);
            return;
        }
        if (sum >= res) return;
        for (int i = 0; i < bikes.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            dfs(workers, idx + 1, bikes, used, sum + distance(workers[idx], bikes[i]));
            used[i] = false;
        }
    }
}

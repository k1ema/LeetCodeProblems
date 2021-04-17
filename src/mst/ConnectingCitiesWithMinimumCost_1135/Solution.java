package mst.ConnectingCitiesWithMinimumCost_1135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1135. Connecting Cities With Minimum Cost
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 *
 * There are N cities numbered from 1 to N.
 *
 * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and
 * city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 *
 * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1)
 * that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.
 *
 * Example 1:
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 *
 * Example 2:
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 *
 * Note:
 * 1 <= N <= 10000
 * 1 <= connections.length <= 10000
 * 1 <= connections[i][0], connections[i][1] <= N
 * 0 <= connections[i][2] <= 10^5
 * connections[i][0] != connections[i][1]
 */
public class Solution {
    // Kruskal's algorithm, Minimum Spanning Tree
    // tc O(n + mlogm + mlog*(n)), tc O(n), where m - number of edges (connections length)
    // log*(n) - for finding / union cities, amortized, never exceeds 5
    public int minimumCost(int N, int[][] connections) {
        List<Integer> mst = new ArrayList<>();
        UnionFind uf = new UnionFind(N + 1);
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.addAll(Arrays.asList(connections));
        while (!pq.isEmpty() && mst.size() < N - 1) {
            int[] conn = pq.poll();
            int v = conn[0], w = conn[1];
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(conn[2]);
            }
        }
        return mst.size() == N - 1 ? mst.stream().mapToInt(i -> i).sum() : -1;
    }

    private static class UnionFind {
        private final int[] id;
        private final int[] size;

        UnionFind(int n) {
            id = new int[n];
            for (int i = 1; i < n; i++) {
                id[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        boolean connected(int v, int w) {
            return find(v) == find(w);
        }

        void union(int v, int w) {
            int rv = find(v);
            int rw = find(w);
            if (rv == rw) return;
            if (size[rv] < size[rw]) {
                id[rv] = rw;
                size[rw] += size[rv];
            } else {
                id[rw] = rv;
                size[rv] += size[rw];
            }
        }

        private int find(int v) {
            while (id[v] != v) {
                id[v] = id[id[v]];
                v = id[v];
            }
            return v;
        }
    }

    // Prim's algorithm
    // tc O(n + mlogn), sc O(n + m), m - number of edges, n - number of cities
    // 29 ms, faster than 40.57%; 46.9 MB, less than 28.62%
    public int minimumCost1(int N, int[][] connections) {
        List<int[]>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            g[conn[0]].add(new int[] {conn[1], conn[2]});
            g[conn[1]].add(new int[] {conn[0], conn[2]});
        }

        int res = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] {1, 0});
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            int[] city = pq.poll();
            if (visited[city[0]]) continue;
            visited[city[0]] = true;
            res += city[1];
            for (int[] dest : g[city[0]]) {
                if (!visited[dest[0]]) {
                    pq.add(dest);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return -1;
        }
        return res;
    }
}

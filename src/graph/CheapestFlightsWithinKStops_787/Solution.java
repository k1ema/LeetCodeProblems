package graph.CheapestFlightsWithinKStops_787;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your
 * task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 *
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 *
 * Constraints:
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */
public class Solution {
    // tc O(k*E*logV) ?, sc O(EV). Dijkstra
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            graph[flight[0]].add(new Edge(flight[0], flight[1], flight[2]));
        }

        int[] distTo = new int[n];
        int[] curStops = new int[n];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        Arrays.fill(curStops, Integer.MAX_VALUE);
        distTo[src] = 0;
        curStops[src] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {src, 0, 0});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int u = info[0];
            int curWeight = info[1];
            int stops = info[2];

            if (u == dst) return curWeight;
            if (stops > K) continue;

            for (Edge e : graph[u]) {
                if (curWeight + e.weight() < distTo[e.to()]) {
                    distTo[e.to()] = curWeight + e.weight();
                    pq.add(new int[] {e.to(), curWeight + e.weight(), stops + 1});
                } else if (stops + 1 < curStops[e.to()]) {
                    curStops[e.to()] = stops + 1;
                    pq.add(new int[] {e.to(), curWeight + e.weight(), stops + 1});
                }
            }
        }

        return -1;
    }

    private class Edge {
        private int u;
        private int v;
        private int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        int from() {
            return u;
        }

        int to() {
            return v;
        }

        int weight() {
            return w;
        }
    }


    // tc O(k*E*logV) ?, sc O(max(V^2, EV))
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new LinkedList<>();
        // a[0] - u, a[1] - v, a[2] - weight
        for (int[] a : flights) {
            graph[a[0]].add(new int[] {a[1], a[2]});
        }
        int[][] weight = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }
        weight[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] {src, 0, 0});
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            if (a[0] == dst) return a[1];
            if (a[2] > K) continue;
            for (int[] nei : graph[a[0]]) {
                if (a[1] + nei[1] < weight[nei[0]][a[2] + 1]) {
                    weight[nei[0]][a[2] + 1] = a[1] + nei[1];
                    pq.add(new int[] {nei[0], a[1] + nei[1], a[2] + 1});
                }
            }
        }
        return -1;
    }

    // Bellman-Ford
    public int findCheapestPrice2(int n, int[][] edges, int src, int dst, int k) {
        int inf = Integer.MAX_VALUE;
        int[] d = new int[n];
        Arrays.fill(d, inf);
        d[src] = 0;
        for (int i = 0; i <= k; ++i) {
            int[] ud = Arrays.copyOf(d, n);
            for (int[] e : edges) {
                int u = e[0], v = e[1], weight = e[2];
                if ((d[u] < inf) && ((d[u] + weight) < d[v]))
                    ud[v] = d[u] + weight;
            }
            d = ud;
        }
        return (d[dst] < inf) ? d[dst] : -1;
    }
}

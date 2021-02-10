package design.ImplementShortestPathViaDijkstra;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath {
    private int src;
    private Edge[] edgeTo;

    int[] shortestReach(int n, int[][] edges, int src) {
        this.src = src;
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
        }

        edgeTo = new Edge[n];
        int[] distTo = new int[n];
        for (int i = 0; i < n; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[src] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {src, 0});
        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            for (Edge e : graph[u[0]]) {
                if (distTo[e.from()] + e.weight() < distTo[e.to()]) {
                    distTo[e.to()] = distTo[e.from()] + e.weight();
                    edgeTo[e.to()] = e;
                    pq.add(new int[] {e.to(), distTo[e.to()]});
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < distTo.length; i++) {
            res[i] = distTo[i] == Integer.MAX_VALUE ? -1 : distTo[i];
        }
        return res;
    }

    List<Integer> pathTo(int v) {
        List<Integer> res = new LinkedList<>();
        Edge cur = edgeTo[v];
        res.add(v);
        while (cur.from() != src) {
            res.add(0, cur.from());
            cur = edgeTo[cur.from()];
        }
        res.add(0, cur.from());
        return res;
    }
}

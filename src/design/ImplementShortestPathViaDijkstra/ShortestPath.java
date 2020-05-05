package design.ImplementShortestPathViaDijkstra;

import java.util.PriorityQueue;

public class ShortestPath {
    int[] shortestReach(int n, int[][] edges, int s) {
        s--;
        Graph graph = new Graph(n);
        for (int[] edge : edges) {
            graph.addEdge(new Edge(edge[0] - 1, edge[1] - 1, edge[2]));
        }

        Edge[] edgeTo = new Edge[n];
        int[] distTo = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {s, 0});
        while (!pq.isEmpty()) {
            int[] v = pq.poll();
            if (visited[v[0]]) continue;
            visited[v[0]] = true;
            for (Edge e : graph.adj(v[0])) {
                if (distTo[e.from()] + e.weight() < distTo[e.to()]) {
                    distTo[e.to()] = distTo[e.from()] + e.weight();
                    edgeTo[e.to()] = e;
                    pq.add(new int[] {e.to(), distTo[e.to()]});
                }
            }
        }
        int[] res = new int[n - 1];
        int j = 0;
        for (int i = 0; i < distTo.length; i++) {
            if (i == s) continue;
            res[j++] = distTo[i] == Integer.MAX_VALUE ? -1 : distTo[i];
        }
        return res;
    }
}

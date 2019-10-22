package graph.CommutableIslands_intbit;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionKruskal implements Solution {
    public int solve(int A, List<List<Integer>> B) {
        Queue<Edge> mst = new LinkedList<>();
        Graph graph = new Graph(A, B);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (List<Integer> list : B) {
            pq.add(new Edge(list.get(0), list.get(1), list.get(2)));
        }
        int sum = 0;
        UF uf = new UF(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.add(e);
            sum += e.weight();
        }

        return sum;
    }

    private class Edge implements Comparable<Edge> {
        private int v;
        private int w;
        private int weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        int either() {
            return v;
        }

        int other(int vertex) {
            if (vertex == v) return w;
            else if (vertex == w) return v;
            else throw new IllegalArgumentException("Wrong vertex: " + vertex);
        }

        int weight() {
            return weight;
        }

        @Override
        public int compareTo(Edge that) {
            return Integer.compare(weight, that.weight());
        }

        @Override
        public String toString() {
            return String.format("[%d,%d,%d]", v, w, weight);
        }
    }

    private class Graph {
        int V;
        List<Edge>[] adj;

        public Graph(int size, List<List<Integer>> B) {
            V = size;
            adj = new LinkedList[size + 1];
            for (int i = 1; i <= size; i++) {
                adj[i] = new LinkedList<>();
            }

            for (List<Integer> list : B) {
                Edge e = new Edge(list.get(0), list.get(1), list.get(2));
                addEdge(e);
            }
        }

        private void addEdge(Edge e) {
            int v = e.either();
            int w = e.other(v);
            adj[v].add(e);
            adj[w].add(e);
        }

        List<Edge> adj(int v) {
            return adj[v];
        }

        public int V() {
            return V;
        }
    }

    private class UF {
        private int n;
        private int[] id;
        private int[] sz; // for weighted Quick-Union

        public UF(int n) {
            this.n = n;
            id = new int[n + 1];
            sz = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        private int root(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]]; // path compression
                i = id[i];
            }
            return i;
        }

        boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (i == j) return;
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
        }
    }

    @Override
    public String toString() {
        return "Kruskal";
    }
}

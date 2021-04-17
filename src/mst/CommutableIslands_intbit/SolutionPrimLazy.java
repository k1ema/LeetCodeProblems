package mst.CommutableIslands_intbit;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Commutable Islands
 * https://www.interviewbit.com/problems/commutable-islands/
 *
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 *
 * We need to find bridges with minimal cost such that all islands are connected.
 *
 * It is guaranteed that input data will contain at least one possible scenario in which all islands
 * are connected with each other.
 *
 * Input Format:
 * The first argument contains an integer, A, representing the number of islands.
 * The second argument contains an 2-d integer matrix, B, of size M x 3:
 *     => Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
 *
 * Output Format:
 * Return an integer representing the minimal cost required.
 *
 * Constraints:
 * 1 <= A, M <= 6e4
 * 1 <= B[i][0], B[i][1] <= A
 * 1 <= B[i][2] <= 1e3
 *
 * Examples:
 * Input 1:
 *     A = 4
 *     B = [   [1, 2, 1]
 *             [2, 3, 4]
 *             [1, 4, 3]
 *             [4, 3, 2]
 *             [1, 3, 10]  ]
 * Output 1:
 *     6
 * Explanation 1:
 *     We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will
 *     be (1 + 3 + 2) = 6.
 *
 * Input 2:
 *     A = 4
 *     B = [   [1, 2, 1]
 *             [2, 3, 2]
 *             [3, 4, 4]
 *             [1, 4, 3]   ]
 * Output 2:
 *     6
 * Explanation 2:
 *     We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will
 *     be (1 + 2 + 3) = 6.
 */
public class SolutionPrimLazy implements Solution {
    private boolean[] marked;
    private PriorityQueue<Edge> pq;

    public int solve(int A, List<List<Integer>> B) {
        marked = new boolean[A + 1];
        Queue<Edge> mst = new LinkedList<>();
        pq = new PriorityQueue<>();
        int sum = 0;
        Graph graph = new Graph(A, B);
        visit(graph, 1); // start point
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.either();
            int w = edge.other(v);

            if (marked[v] && marked[w]) continue;
            mst.add(edge);
            sum += edge.weight();

            if (!marked[v]) visit(graph, v);
            if (!marked[w]) visit(graph, w);
        }

        return sum;
    }

    private void visit(Graph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.other(v)]) pq.add(edge);
        }
    }

    private class Graph {
        private List<Edge>[] adj;

        Graph(int size, List<List<Integer>> B) {
            adj = new LinkedList[size + 1];
            for (int i = 1; i <= size; i++) {
                adj[i] = new LinkedList<>();
            }
            for (List<Integer> list : B) {
                Edge e = new Edge(list.get(0), list.get(1), list.get(2));
                addEdge(e);
            }
        }

        List<Edge> adj(int v) {
            return adj[v];
        }

        private void addEdge(Edge e) {
            int v = e.either();
            int w = e.other(v);
            adj[v].add(e);
            adj[w].add(e);
        }
    }

    private class Edge implements Comparable<Edge> {
        private int v;
        private int w;
        private int weight;

        private Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        private int either() {
            return v;
        }

        private int other(int vertex) {
            if (vertex == v) return w;
            else if (vertex == w) return v;
            else throw new RuntimeException("Wrong vertex: " + vertex);
        }

        private int weight() {
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

    @Override
    public String toString() {
        return "Prim Lazy";
    }
}

package unionFind.RedundantConnection_684;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 684. Redundant Connection
 * https://leetcode.com/problems/redundant-connection/
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values
 * 1, 2, ..., N), with one additional edge added. The added edge has two different vertices
 * chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair
 * [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes.
 * If there are multiple answers, return the answer that occurs last in the given 2D-array.
 * The answer edge [u, v] should be in the same format, with u < v.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 *
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 *
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is
 * the size of the input array.
 *
 * Update (2017-09-26):
 * We have overhauled the problem description + test cases and specified clearly
 * the graph is an undirected graph. For the directed graph follow up please see
 * Redundant Connection II). We apologize for any inconvenience caused.
 */
public class Solution {
    // https://www.youtube.com/watch?v=wU6udHRIkcc
    // https://en.wikipedia.org/wiki/Disjoint-set_data_structure
    // https://leetcode.com/problems/redundant-connection/discuss/123819/Union-Find-with-Explanations-(Java-Python)
    // https://www.geeksforgeeks.org/union-find/
    // see comments, short variant without ranks, just union two trees to the 2nd one, works faster
    // tc O(n), sc O(n)
    int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length + 1];
        for (int[] edge : edges) {
            int u = find(parent, edge[0]);
            int v = find(parent, edge[1]);
            if (u == v) return edge;
            parent[u] = v;
        }
        return new int[] {};
    }

    private int find(int[] parent, int x) {
        while (parent[x] != 0) x = parent[x]; // Path compression by halving.
        return x;
    }

    // https://leetcode.com/problems/redundant-connection/discuss/123819/Union-Find-with-Explanations-(Java-Python)
    // https://www.youtube.com/watch?v=ID00PMy0-vE
    // classic solution with ranks, rank means the depth of tree
    // tc O(n), sc O(n)
    int[] findRedundantConnection1(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        byte[] rank = new byte[edges.length + 1];
        for (int[] edge : edges) {
            int rootU = find(parent, edge[0]);
            int rootV = find(parent, edge[1]);
            if (rootU == rootV) return edge;
            if (rank[rootU] <= rank[rootV]) {
                parent[rootU] = rootV;
                // we change parent's rank only if two ranks are equal, otherwise rank does not change
                if (rank[rootU] == rank[rootV]) {
                    rank[rootV]++;
                }
            } else {
                parent[rootV] = rootU;
            }
        }
        return new int[] {};
    }


    private int MAX_EDGE_VAL = 1000;
    private Set<Integer> seen = new HashSet<>(MAX_EDGE_VAL);

    // tc O(n^2), sc O(n)
    // https://leetcode.com/problems/redundant-connection/solution/
    int[] findRedundantConnection2(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
        for (int i = 0; i <= MAX_EDGE_VAL; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            seen.clear();
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1])) {
                return edge;
            }

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        throw new AssertionError();
    }

    private boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) return true;

            for (int v : graph[source]) {
                if (dfs(graph, v, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}

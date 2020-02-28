package graph.MinimumHeightTrees_310;

import java.util.*;

/**
 * 310. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/
 *
 * For an undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees, those with minimum
 * height are called minimum height trees (MHTs). Given such a graph, write a function to find
 * all the MHTs and return a list of their root labels.
 *
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n
 * and a list of undirected edges (each edge is a pair of labels).
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Example 1 :
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 * Output: [1]
 *
 * Example 2 :
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 * Output: [3, 4]
 *
 *  Note:
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which
 * any two vertices are connected by exactly one path. In other words, any connected graph
 * without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between
 * the root and a leaf.
 */
public class Solution {
    // tc O(n), sc O(n)
    // https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts
    List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(0);

        Set<Integer>[] graph = buildGraph(n, edges);

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            Set<Integer> vertices = graph[i];
            if (vertices.size() == 1) leaves.add(i);
        }

        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            n -= leaves.size();
            for (int i = 0; i < leaves.size(); i++) {
                int l = leaves.get(i);
                int v = graph[l].iterator().next();
                graph[v].remove(l);
                if (graph[v].size() == 1) newLeaves.add(v);
            }
            leaves = newLeaves;
        }

        return leaves;
    }

    private Set<Integer>[] buildGraph(int n, int[][] edges) {
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
}

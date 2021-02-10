package graph.MinimumHeightTrees_310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (n == 1) return Collections.singletonList(0);
        Set<Integer>[] graph = buildGraph(n, edges);
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            n -= leaves.size();
            for (int i : leaves) {
                for (int v : graph[i]) {
                    graph[v].remove(i);
                    if (graph[v].size() == 1) {
                        newLeaves.add(v);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    private Set<Integer>[] buildGraph(int n, int[][] edges) {
        Set<Integer>[] g = new HashSet[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        return g;
    }

    // TLE, tc O(E*V), sc O(E*V). Since for each tree E = V - 1, tc O(n^2), sc O(n^2)
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph1(n, edges);
        List<Integer> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int curHeight = dfs(graph, i, new boolean[n]);
            min = Math.min(min, curHeight);
            pairs.add(new int[] {curHeight, i});
        }
        for (int[] p : pairs) {
            if (p[0] == min) res.add(p[1]);
        }
        return res;
    }

    private int dfs(List<Integer>[] graph, int i, boolean[] visited) {
        int res = 0;
        visited[i] = true;
        for (int nei : graph[i]) {
            if (!visited[nei]) {
                res = Math.max(res, 1 + dfs(graph, nei, visited));
            }
        }
        return res;
    }

    private List<Integer>[] buildGraph1(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        return g;
    }
}

package graph.CriticalConnectionsInANetwork_1192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 1192. Critical Connections in a Network
 * https://leetcode.com/problems/critical-connections-in-a-network/
 *
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections
 * forming a network where connections[i] = [a, b] represents a connection between servers a and b.
 * Any server can reach any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some
 * other server.
 *
 * Return all critical connections in the network in any order.
 *
 * Example 1:
 * 1 — 2
 * | \ |
 * 3   0
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 *
 * Constraints:
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 */
public class Solution {
    int id; // current id

    // tc O(V + E), sc O(VE)
    // 91 ms, faster than 55.61%; 109 MB, less than 100.00%
    // https://www.youtube.com/watch?v=aZXi1unBdJA
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        id = 0;
        int[] disc = new int[n], low = new int[n];
        // use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // build graph
        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        dfs(0, low, disc, graph, res, -1);
        return res;
    }

    private void dfs(int u, int[] low, int[] ids, List<Integer>[] graph, List<List<Integer>> res, int pre) {
        ids[u] = low[u] = id++; // discover u
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);
            if (v == pre) {
                continue; // if parent vertex, ignore
            }
            if (ids[v] == -1) { // if not discovered
                dfs(v, low, ids, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > ids[u]) {
                    // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    res.add(Arrays.asList(u, v));
                }
            } else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
                low[u] = Math.min(low[u], ids[v]);
            }
        }
    }

    // tc O(V + E)
    // 90 ms, faster than 63.76%; 101.9 MB, less than 100.00%
    // https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/No-TarjanDFS-detailed-explanation-O(orEor)-solution-(I-like-this-question)
    public List<List<Integer>> criticalConnections1(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = buildGraph(n, connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, n, 0, 0, rank, res);
        return res;
    }

    private int dfs(List<Integer>[] graph, int n, int node, int depth, int[] rank, List<List<Integer>> res) {
        if (rank[node] >= 0) return rank[node]; // visiting (0 <= rank < n), or visited (rank = n)

        int lowestRank = depth;
        rank[node] = depth;

        for (int neighbor : graph[node]) {
            if (rank[neighbor] == depth - 1 || rank[neighbor] == n) {
                // rank[neighbor] == myRank - 1: parent node
                // Do not go back immediately to parent, this will lead to parent-child-parent circle immediately.
                // This is why NO_RANK is set to -2 instead of -1, because the first node of a recursion has myRank 0.
                //
                // rank[neighbor] == n:
                // Do not include node=>neighbor in the result. Reason:
                // This can be explained from a couple of aspects:
                // - This means neighbor has been finished, so neighbor=>node has been decided before neighbor is finished,
                //   and if neighbor=>node is already decided, we don't need to make a decision on node=>neighbor because
                //   it is undirected graph.
                // - When neighbor=>node was decided, the decision must be "not include it in the result", because
                //   node is an ancestor of neighbor, so neighbor=>node is a back edge, meaning at that time it already
                //   detected that there is a cycle between neighbor and node, so that edge would not be included in the result.
                continue;
            }

            int neighborRank = dfs(graph, n, neighbor, depth + 1, rank, res);
            lowestRank = Math.min(lowestRank, neighborRank);
            if (neighborRank > depth) {
                res.add(Arrays.asList(node, neighbor));
            }
        }

        rank[node] = n;
        return lowestRank;
    }

    // time limit exceeded
    // tc O(EV), sc O(EV)
    public List<List<Integer>> criticalConnections2(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = buildGraph(n, connections);
        List<List<Integer>> res = new LinkedList<>();
        int edgeRemoved = 0;
        while (edgeRemoved < connections.size()) {
            List<Integer> edge = connections.get(edgeRemoved);
            boolean[] visited = new boolean[n];
            dfs(graph, 0, edge, visited);
            if (checkCritical(visited)) res.add(edge);
            edgeRemoved++;
        }
        return res;
    }

    private boolean checkCritical(boolean[] visited) {
        return IntStream.range(0, visited.length).anyMatch(i -> !visited[i]);
    }

    private void dfs(List<Integer>[] graph, int ind, List<Integer> edgeRemoved, boolean[] visited) {
        if (visited[ind]) return;
        visited[ind] = true;
        for (int w : graph[ind]) {
            if (edgeRemoved.contains(ind) && edgeRemoved.contains(w)) continue;
            if (!visited[w]) dfs(graph, w, edgeRemoved, visited);
        }
    }

    private List<Integer>[] buildGraph(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        return graph;
    }
}

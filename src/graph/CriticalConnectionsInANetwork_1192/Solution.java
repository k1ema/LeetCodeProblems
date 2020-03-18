package graph.CriticalConnectionsInANetwork_1192;

import java.util.*;
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
    // tc O(|E|)
    // 90 ms, faster than 63.76%; 101.9 MB, less than 100.00%
    // https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/No-TarjanDFS-detailed-explanation-O(orEor)-solution-(I-like-this-question)
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = buildGraph(n, connections);
        int[] ranks = new int[n];
        Arrays.fill(ranks, -2);
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, n, 0, 0, ranks, res);
        return res;
    }

    private int dfs(List<Integer>[] graph, int n, int node, int depth, int[] ranks, List<List<Integer>> res) {
        if (ranks[node] >= 0) return ranks[node]; // visiting (0<=rank<n), or visited (rank=n)

        int lowestRank = depth;
        ranks[node] = depth;

        for (int neighbor : graph[node]) {
            if (ranks[neighbor] == depth - 1 || ranks[neighbor] == n) {
                // ranks[neighbor] == myRank - 1:
                // Do not go back immediately to parent, this will lead to
                // parent-child-parent circle immediately.
                // This is why NO_RANK is set to -2 instead of -1, because the first node of a recursion has myRank 0.
                //
                // ranks[neighbor] == n:
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

            int neighborRank = dfs(graph, n, neighbor, depth + 1, ranks, res);
            lowestRank = Math.min(lowestRank, neighborRank);
            if (neighborRank > depth) {
                res.add(Arrays.asList(node, neighbor));
            }
        }

        ranks[node] = n;
        return lowestRank;
    }

    // time limit exceeded
    // tc O(EV), sc O(EV)
    public List<List<Integer>> criticalConnections1(int n, List<List<Integer>> connections) {
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

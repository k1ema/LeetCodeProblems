package graph.NetworkDelayTime_743;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time/
 *
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source
 * node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the
 * signal? If it is impossible, return -1.
 *
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 *
 * Note:
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */
public class Solution {
    // Dijkstra algorithm (similar to BFS, just use PriorityQueue instead of Queue)
    // https://leetcode.com/problems/network-delay-time/discuss/210698/Java-Djikstrabfs-Concise-and-very-easy-to-understand
    // 75 ms, faster than 14.38%; 55.2 MB, less than 35.71%
    int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            graph.putIfAbsent(times[i][0], new HashMap<>());
            graph.get(times[i][0]).put(times[i][1], times[i][2]);
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[] {K, 0});
        int res = 0;
        boolean[] visited = new boolean[N + 1];
        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            int curNode = u[0];
            int curDist = u[1];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if (graph.containsKey(curNode)) {
                for (Map.Entry<Integer, Integer> e : graph.get(curNode).entrySet()) {
                    queue.add(new int[] {e.getKey(), curDist + e.getValue()});
                }
            }
        }
        return N > 0 ? -1 : res;
    }

    int networkDelayTime2(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();
        for (int node = 1; node <= N; node++) {
            dist.put(node, Integer.MAX_VALUE);
        }

        dist.put(K, 0);
        boolean[] seen = new boolean[N + 1];

        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) break;
            seen[candNode] = true;
            if (graph.containsKey(candNode)) {
                for (int[] info : graph.get(candNode)) {
                    dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
                }
            }
        }

        int ans = 0;
        for (int cand : dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}

package design.ImplementTarjan;

import java.util.*;

/**
 * Allows finding a strongly connected components in a directed graph
 *
 * https://www.youtube.com/watch?v=TyWtx7q2D7Y
 * https://www.youtube.com/watch?v=hKhLj7bfDKk
 */
public class Tarjan {
    private int id;
    private boolean[] onStack;
    private int[] ids, low;
    private Deque<Integer> stack;
    private int sccCount;
    private List<Integer>[] graph;

    int findSCC(int n, int[][] graph) {
        id = 0;
        sccCount = 0;
        onStack = new boolean[n];
        ids = new int[n];
        Arrays.fill(ids, -1);
        low = new int[n];
        stack = new ArrayDeque<>();
        this.graph = buildGraph(n, graph);

        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) dfs(i);
        }

        return sccCount;
    }

    private void dfs(int u) {
        ids[u] = low[u] = id++;
        stack.push(u);
        onStack[u] = true;

        for (int v : graph[u]) {
            if (ids[v] == -1) dfs(v);
            if (onStack[v]) low[u] = Math.min(low[v], low[u]);
        }

        if (ids[u] == low[u]) {
            while (!stack.isEmpty()) {
                int node = stack.pop();
                onStack[node] = false;
                low[node] = ids[u];
                if (node == u) break;
            }
            sccCount++;
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] graph) {
        List<Integer>[] res = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int[] nums : graph) {
            res[nums[0]].add(nums[1]);
        }
        return res;
    }
}

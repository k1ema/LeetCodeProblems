package graph.EvaluateDivision_399;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 399. Evaluate Division
 * https://leetcode.com/problems/evaluate-division/
 *
 * Equations are given in the format A / B = k, where A and B are variables represented
 * as strings, and k is a real number (floating point number). Given some queries, return
 * the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?,  b / a = ?,  a / e = ?,  a / a = ?,  x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() == values.size(),
 * and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 *
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 */
public class Solution {
    // DFS, tc O(M * N), sc O(N), where N = equations.length, M - queries.length
    // 1 ms, faster than 71.90%; 37.9 MB, less than 85.95%
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> eq = equations.get(i);
            map.putIfAbsent(eq.get(0), new HashMap<>());
            map.putIfAbsent(eq.get(1), new HashMap<>());
            map.get(eq.get(0)).put(eq.get(1), values[i]);
            map.get(eq.get(1)).put(eq.get(0), 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            List<String> q = queries.get(i);
            res[i] = dfs(q.get(0), q.get(1), map, new HashSet<>());
        }

        return res;
    }

    private double dfs(String s, String t, Map<String, Map<String, Double>> map, Set<String> seen) {
        if (!map.containsKey(s) || seen.contains(s)) return -1;
        if (s.equals(t)) return 1;
        seen.add(s);
        for (Map.Entry<String, Double> entry : map.get(s).entrySet()) {
            double val = dfs(entry.getKey(), t, map, seen);
            if (val != -1) return val * entry.getValue();
        }
        return -1;
    }

    // BFS, tc O(M * N), sc O(N), where N = equations.length, M - queries.length
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String ai = eq.get(0), bi = eq.get(1);
            graph.putIfAbsent(ai, new HashMap<>());
            graph.get(ai).put(bi, values[i]);
            graph.putIfAbsent(bi, new HashMap<>());
            graph.get(bi).put(ai, 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String ci = queries.get(i).get(0), di = queries.get(i).get(1);
            res[i] = -1.0;
            if (!graph.containsKey(ci)) {
                continue;
            }
            Queue<Map.Entry<String, Double>> q = new ArrayDeque<>();
            q.add(Map.entry(ci, 1.0));
            Set<String> visited = new HashSet<>();
            visited.add(ci);
            while (!q.isEmpty()) {
                Map.Entry<String, Double> e = q.poll();
                String cur_name = e.getKey();
                double cur_val = e.getValue();
                if (cur_name.equals(di)) {
                    res[i] = cur_val;
                    break;
                }
                if (graph.containsKey(cur_name)) {
                    for (Map.Entry<String, Double> childEntry : graph.get(cur_name).entrySet()) {
                        String childName = childEntry.getKey();
                        if (!visited.contains(childName)) {
                            q.add(Map.entry(childName, cur_val * childEntry.getValue()));
                            visited.add(childName);
                        }
                    }
                }
            }
        }
        return res;
    }

    // union-find approach
    // tc O((M + N)log*N), sc O(N),
    // where N = equations.length, M - queries.length
    // 0 ms, faster than 100.00%; 37.8 MB, less than 90.75%
    // https://leetcode.com/problems/evaluate-division/discuss/147281/Java-Union-Find-solution-faster-than-99
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> root = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String s = equations.get(i).get(0), t = equations.get(i).get(1);
            String r1 = find(root, dist, s);
            String r2 = find(root, dist, t);
            root.put(r1, r2);
            dist.put(r1, dist.get(t) * values[i] / dist.get(s));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            String s = queries.get(i).get(0);
            String t = queries.get(i).get(1);
            if (!root.containsKey(s) || !root.containsKey(t)) {
                res[i] = -1;
                continue;
            }
            String rootS = find(root, dist, s);
            String rootT = find(root, dist, t);
            if (rootS.equals(rootT)) {
                res[i] = dist.get(s) / dist.get(t);
            } else {
                res[i] = -1;
            }
        }

        return res;
    }

    private String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s)) return s;
        String rootS = root.get(s);
        String rootRootS = find(root, dist, rootS);
        root.put(s, rootRootS);
        dist.put(s, dist.get(s) * dist.get(rootS));
        return rootRootS;
    }
}

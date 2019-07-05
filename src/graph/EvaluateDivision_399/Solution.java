package graph.EvaluateDivision_399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> m = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            m.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            m.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            m.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            m.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }

        double[] r = new double[queries.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), m, new HashSet<>(), 1.0);
        }
        return r;
    }

    private double dfs(String s, String t, Map<String, Map<String, Double>> m, Set<String> seen, double k) {
        if (!m.containsKey(s) || !seen.add(s)) return -1;
        if (s.equals(t)) return k;

        Map<String, Double> map = m.get(s);
        for (Entry<String, Double> e : map.entrySet()) {
            double result = dfs(e.getKey(), t, m, seen, k * e.getValue());
            if (result != -1) return result;
        }
        return -1;
    }
}

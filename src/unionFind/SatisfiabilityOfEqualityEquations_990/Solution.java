package unionFind.SatisfiabilityOfEqualityEquations_990;

import java.util.Arrays;

/**
 * 990. Satisfiability of Equality Equations
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 *
 * Given an array equations of strings that represent relationships between
 * variables, each string equations[i] has length 4 and takes one of two
 * different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters
 * (not necessarily different) that represent one-letter variable names.
 *
 * Return true if and only if it is possible to assign integers to variable
 * names so as to satisfy all the given equations.
 *
 * Example 1:
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is
 * satisfied, but not the second.  There is no way to assign the variables to
 * satisfy both equations.
 *
 * Example 2:
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 *
 * Example 3:
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 *
 * Example 4:
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 *
 * Example 5:
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 *
 * Note:
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] and equations[i][3] are lowercase letters
 * equations[i][1] is either '=' or '!'
 * equations[i][2] is '='
 */
public class Solution {
    // tc O(n), sc O(1)
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet();
        for (String s : equations) {
            int u = s.charAt(0) - 'a';
            int v = s.charAt(3) - 'a';
            if (s.charAt(1) == '=') {
                ds.union(u, v);
            }
        }

        for (String s : equations) {
            int u = s.charAt(0) - 'a';
            int v = s.charAt(3) - 'a';
            if (s.charAt(1) == '!') {
                if (ds.find(u) == ds.find(v)) return false;
            }
        }

        return true;
    }

    private static class DisjointSet {
        private final int[] id;
        private final int[] weights;

        DisjointSet() {
            id = new int[26];
            for (int i = 0; i < 26; i++) {
                id[i] = i;
            }
            weights = new int[26];
            Arrays.fill(weights, 1);
        }

        // tc amortized O(1)
        public int find(int u) {
            while (id[u] != u) {
                id[u] = id[id[u]];
                u = id[u];
            }
            return id[u];
        }

        // tc amortized  O(1)
        public void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return;
            if (weights[pu] < weights[pv]) {
                id[pu] = pv;
                weights[pv] += weights[pu];
            } else {
                id[pv] = pu;
                weights[pu] += weights[pv];
            }
        }
    }
}

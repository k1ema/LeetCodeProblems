package unionFind.LargestComponentSizeByCommonFactor_952;

import java.util.*;

/**
 * 952. Largest Component Size by Common Factor
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 *
 * Given a non-empty array of unique positive integers A, consider the following graph:
 *  - There are A.length nodes, labelled A[0] to A[A.length - 1];
 *  - There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common
 *      factor greater than 1.
 * Return the size of the largest connected component in the graph.
 *
 * Example 1:
 * Input: [4,6,15,35]
 * Output: 4
 *  4 --- 6 --- 15 --- 35
 *
 * Example 2:
 * Input: [20,50,9,63]
 * Output: 2
 *  20 --- 50,   9 --- 63
 *
 * Example 3:
 * Input: [2,3,6,7,4,12,21,39]
 * Output: 8
 *
 * Note:
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 100000
 */
public class Solution {
    // tc O(N * logM * log(*)M), sc O(N + M)
    // where N is the number of elements in the input list, and M is the maximum value of the input list.
    // 213 ms, faster than 46.98%; 76.6 MB, less than 22.33%
    public int largestComponentSize(int[] A) {
        int maxValue = Arrays.stream(A).reduce(A[0], Math::max);
        UF uf = new UF(maxValue + 1);

        for (int num : A) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    uf.union(num, factor);
                    uf.union(num, num / factor);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int groupId;
        int maxGroupSize = 1;
        for (int num : A) {
            groupId = uf.find(num);
            map.put(groupId, map.getOrDefault(groupId, 0) + 1);
            maxGroupSize = Math.max(maxGroupSize, map.get(groupId));
        }

        return maxGroupSize;
    }

    private class UF {
        private int[] id;
        private int[] sz;

        UF(int size) {
            id = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
            }
            sz = new int[size];
            Arrays.fill(sz, 1);
        }

        void union(int i, int j) {
            int pi = find(id[i]);
            int pj = find(id[j]);
            if (pi == pj) return;
            if (sz[pi] < sz[pj]) {
                id[pi] = pj;
                sz[pj] += sz[pi];
            } else {
                id[pj] = pi;
                sz[pi] += sz[pj];
            }
        }

        boolean connected(int i, int j) {
            return find(i) == find(j);
        }

        int find(int i) {
            while (id[i] != i) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}

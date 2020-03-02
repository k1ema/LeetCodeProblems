package unionFind.MostStonesRemovedWithSameRowOrColumn_947;

import java.util.HashSet;
import java.util.Set;

/**
 * 947. Most Stones Removed with Same Row or Column
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point
 * may have at most one stone.
 *
 * Now, a move consists of removing a stone that shares a column or row with another stone on
 * the grid.
 *
 * What is the largest possible number of moves we can make?
 *
 * Example 1:
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 *
 * Example 2:
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 *
 * Example 3:
 * Input: stones = [[0,0]]
 * Output: 0
 *
 * Note:
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 */
public class Solution {
    // [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
    //      1,2     2,2
    //
    // 0,1
    //
    // 0,0	1,0     2,1
    //
    // parent:
    // 10000	10001	10002	10001	2	    10002
    // 0	    1	    2	    10000	10001	10002
    // set: 10002
    //
    //
    // [[0,0],[0,2],[1,1],[2,0],[2,2]]
    //  0,2		2,2
    //
    //	    1,1
    //
    //  0,0		2,0
    //
    // parent:
    // 10000	10001	10002	10002	10001	10002
    // 0    	1	    2	    10000	10001	10002
    // set: 10002, 10001

    // tc O(nlogn), sc O(n)
    // 9 ms, faster than 78.81%; 41.8 MB, less than 75.00%
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(20000);

        for (int[] stone : stones) {
            dsu.union(stone[0], stone[1] + 10000);
        }

        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(dsu.find(stone[0]));
        }

        return stones.length - set.size();
    }

    private class DSU {
        private int[] parent;

        DSU (int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) return x;
            return find(parent[x]);
        }

        void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}

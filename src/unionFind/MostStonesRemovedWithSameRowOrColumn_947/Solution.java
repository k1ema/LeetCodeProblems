package unionFind.MostStonesRemovedWithSameRowOrColumn_947;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    // tc O(nlogn), sc O(20000)
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
        private int[] id;
        private int[] sz; // for weighted union

        DSU (int n) {
            this.id = new int[n];
            this.sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        int find(int x) {
            while (x != id[x]) {
                id[x] = id[id[x]]; // line for path compression
                x = id[x];
            }
            return x;
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (sz[px] < sz[py]) {
                id[px] = py;
                sz[py] += sz[px];
            } else {
                id[py] = px;
                sz[px] += sz[py];
            }
        }
    }

    // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197668/Count-the-Number-of-Islands-O(N)
    // tc O(n^2), sc O(n)
    // 8 ms, faster than 87.50%; 41.9 MB, less than 75.00%
    Map<Integer, Integer> f;
    int islands;

    public int removeStones2(int[][] stones) {
        f = new HashMap<>();
        islands = 0;
        for (int i = 0; i < stones.length; ++i) {
            union(stones[i][0], stones[i][1] + 10000);
        }
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null) {
            islands++;
        }
        if (x != f.get(x)) {
            f.put(x, find(f.get(x)));
        }
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }
}

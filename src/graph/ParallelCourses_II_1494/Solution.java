package graph.ParallelCourses_II_1494;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1494. Parallel Courses II
 * https://leetcode.com/problems/parallel-courses-ii/
 *
 * Given the integer n representing the number of courses at some university labeled from 1 to n,
 * and the array dependencies where dependencies[i] = [xi, yi]  represents a prerequisite relationship,
 * that is, the course xi must be taken before the course yi.  Also, you are given the integer k.
 *
 * In one semester you can take at most k courses as long as you have taken all the prerequisites for
 * the courses you are taking.
 *
 * Return the minimum number of semesters to take all courses. It is guaranteed that you can take all
 * courses in some way.
 *
 * Example 1:
 * Input: n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2
 * Output: 3
 * Explanation: The figure above represents the given graph. In this case we can take courses 2 and 3 in
 * the first semester, then take course 1 in the second semester and finally take course 4 in the third semester.
 *
 * Example 2:
 * Input: n = 5, dependencies = [[2,1],[3,1],[4,1],[1,5]], k = 2
 * Output: 4
 * Explanation: The figure above represents the given graph. In this case one optimal way to take all
 * courses is: take courses 2 and 3 in the first semester and take course 4 in the second semester, then take
 * course 1 in the third semester and finally take course 5 in the fourth semester.
 *
 * Example 3:
 * Input: n = 11, dependencies = [], k = 2
 * Output: 6
 *
 * Constraints:
 * 1 <= n <= 15
 * 1 <= k <= n
 * 0 <= dependencies.length <= n * (n-1) / 2
 * dependencies[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * All prerequisite relationships are distinct, that is, dependencies[i] != dependencies[j].
 * The given graph is a directed acyclic graph.
 */
public class Solution {
    public int minNumberOfSemesters(int n, int[][] deps, int k) {
        int[] preq = new int[n];
        for (int[] dep : deps) {
            // to study j, what are the prerequisites? each set bit is a class that we need to take. ith bit means ith class
            // -1 because classes are 1 to n
            preq[dep[1] - 1] |= 1 << (dep[0] - 1);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            // we are now at status i. we can "influence" a later status from this status
            int canStudy = 0; // what are the classes we can study?
            for (int j = 0; j < n; j++) {
                // a & b == b means b is a's subset
                // so if preq[j] is i's subset, we can now study j given status i
                if ((i & preq[j]) == preq[j]) {
                    canStudy |= (1 << j);
                }
            }
            canStudy &= ~i;
            // take out i, so that we only enumerate a subset canStudy without i.
            // note we will | later so here we need a set that has no intersection with i to reduce the enumeration cost
            for (int sub = canStudy; sub > 0; sub = (sub - 1) & canStudy) {
                // we can study one or more courses indicated by set "canStudy". we need to enumerate all non empty subset of it.
                // This for loop is a typical way to enumerate all subsets of a given set "canStudy"
                // we studied i using dp[i] semesters. now if we also study the subset sub, we need dp [i ]+1 semesters,
                // and the status we can "influence" is dp[ i | sub] because at that state, we studied what we want to study in "sub"
                if (Integer.bitCount(sub) <= k) {
                    dp[i | sub] = Math.min(dp[i | sub], dp[i] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    // https://leetcode.com/problems/parallel-courses-ii/discuss/708120/Java-Solution-Priority-Queue-%2B-Topological-Sort
    // https://leetcode.com/problems/parallel-courses-ii/discuss/708164/Java-Topological-Sort-%2B-PriorityQueue-of-outdegrees

    // this problem is very similar to Course Schedule which is straightforward implementation of Topological sorting.
    // In this case the only difference is we have a constraint on how many courses can be taken in parallel during a semester
    // and to handle that I used PQ of outdegrees and greedily choosing the course with highest outdegree to do next
    // (i.e the course that will free up most number of dependent courses).

    // 2 ms, faster than 100.00%; 37.4 MB, less than 100.00%
    public int minNumberOfSemesters1(int n, int[][] dependencies, int k) {
        List<Integer>[] graph = buildGraph(n, dependencies);
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        for (int[] dep : dependencies) {
            indegree[dep[1]]++;
            outdegree[dep[0]]++;
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> outdegree[b] - outdegree[a]);
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) pq.add(i);
        }

        int res = 0;
        while (!pq.isEmpty()) {
            res++;

            int size = Math.min(k, pq.size());
            Queue<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                tmp.add(pq.poll());
            }
            while (!tmp.isEmpty()) {
                for (int adj : graph[tmp.poll()]) {
                    if (--indegree[adj] <= 0) {
                        pq.add(adj);
                    }
                }
            }
        }

        return res;
    }

    private List<Integer>[] buildGraph(int n, int[][] dependencies) {
        List<Integer>[] g = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] dep : dependencies) {
            g[dep[0]].add(dep[1]);
        }
        return g;
    }

//    public int minNumberOfSemesters1(int n, int[][] dependencies, int k, int mask) {
//        List<Integer>[] graph = buildGraph(n, dependencies);
//        int[] depth = new int[n + 1];
//        Arrays.fill(depth, 1);
//        for (int i = 0; i < graph.length; i++) {
//            dfs(graph, i, depth);
//        }
//        int sems = IntStream.of(depth).max().orElse(0);
//        int count = 0;
//        for (int i = 1; i < depth.length; i++) {
//            if (depth[i] == sems) count++;
//        }
//        if (sems != 1) {
//            for (int i = 1; i < graph.length; i++) {
//                if (graph[i].isEmpty()) {
//                    boolean contains = false;
//                    for (int j = 1; j < graph.length; j++) {
//                        if (i == j) continue;
//                        if (graph[j].contains(i)) {
//                            contains = true;
//                            break;
//                        }
//                    }
//                    if (!contains) count++;
//                }
//            }
//        }
//        return (int) Math.ceil(count / (k * 1d)) + sems - 1;
//    }

//    private void dfs(List<Integer>[] graph, int k, int ind, int[] depth, int mask) {
//        if (ind == graph.length || ((mask >> ind) & 1) == 1) return;
//        mask |= 1 << ind;
//        for (int j : graph[ind]) {
//            dfs(graph, k, j, depth, mask);
//            depth[ind] = Math.max(depth[ind], 1 + depth[j]);
//        }
//
//        depth[ind] = Math.max(depth[ind], 1);
//    }
}

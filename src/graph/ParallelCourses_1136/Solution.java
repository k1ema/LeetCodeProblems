package graph.ParallelCourses_1136;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 1136. Parallel Courses
 * https://leetcode.com/problems/parallel-courses/
 *
 * There are N courses, labelled from 1 to N.
 *
 * We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and
 * course Y: course X has to be studied before course Y.
 *
 * In one semester you can study any number of courses as long as you have studied all the prerequisites
 * for the course you are studying.
 *
 * Return the minimum number of semesters needed to study all courses.  If there is no way to study all
 * the courses, return -1.
 *
 * Example 1:
 * Input: N = 3, relations = [[1,3],[2,3]]
 * Output: 2
 * Explanation:
 * In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
 *
 * Example 2:
 * Input: N = 3, relations = [[1,2],[2,3],[3,1]]
 * Output: -1
 * Explanation:
 * No course can be studied because they depend on each other.
 *
 * Note:
 * 1 <= N <= 5000
 * 1 <= relations.length <= 5000
 * relations[i][0] != relations[i][1]
 * There are no repeated relations in the input.
 */
public class Solution {
    // topological sort, tc O(V + E), sc O(n), where n - the longest path
    // 57 ms, faster than 9.92%, 44.5 MB, less than 100.00%
    int minimumSemesters(int N, int[][] relations) {
        List<Integer>[] graph = buildGraph(N, relations);
        int[] depth = new int[N + 1];
        for (int i = 1; i < graph.length; i++) {
            if (!dfs(graph, new boolean[N + 1], new boolean[N + 1], i, depth)) return -1;
        }
        return IntStream.of(depth).max().orElse(-1);
    }

    private boolean dfs(List<Integer>[] graph, boolean[] visited, boolean[] marked, int ind, int[] depth) {
        if (marked[ind]) return false; // found cycle
        if (visited[ind]) return true;

        visited[ind] = true;
        marked[ind] = true;

        for (int j : graph[ind]) {
            if (!dfs(graph, visited, marked, j, depth)) return false;
            depth[ind] = Math.max(depth[ind], 1 + depth[j]);
        }

        marked[ind] = false;
        depth[ind] = Math.max(depth[ind], 1);
        return true;
    }

    private List<Integer>[] buildGraph(int N, int[][] relations) {
        List<Integer>[] res = new LinkedList[N + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = new LinkedList<>();
        }
        for (int i = 0; i < relations.length; i++) {
            res[relations[i][0]].add(relations[i][1]);
        }
        return res;
    }
}

package graph.ParallelCourses_1136;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
    // bfs, tc O(V + E), sc O(V + E)
    // 5 ms, faster than 95.13%; 40.3 MB, less than 74.18%
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];
        for (int[] rel : relations) {
            graph[rel[0]].add(rel[1]);
            indegree[rel[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                indegree[i] = -1;
                visited[i] = true;
            }
        }

        int semesters = 0, visitedCount = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            semesters++;
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                visitedCount++;
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        indegree[v]--;
                        if (indegree[v] == 0) {
                            q.add(v);
                            indegree[v] = -1;
                            visited[v] = true;
                        }
                    }
                }
            }
        }

        return semesters == 0 || visitedCount != n ? -1 : semesters;
    }

    // dfs, topological sort, tc O(V + E), sc O(n), where n - the longest path
    // 6 ms, faster than 78.13%; 40.8 MB, less than 63.37%
    public int minimumSemesters1(int n, int[][] relations) {
        List<Integer>[] graph = buildGraph(n, relations);
        int[] depth = new int[n + 1];
        int[] state = new int[n + 1];
        for (int i = 1; i < graph.length; i++) {
            if (state[i] == 0) {
                if (!dfs(graph, state, i, depth)) {
                    return -1;
                }
            }
        }
        return IntStream.of(depth).max().orElse(-1);
    }

    private boolean dfs(List<Integer>[] graph, int[] state, int u, int[] depth) {
        if (state[u] == 1) return false; // found cycle

        state[u] = 1;
        for (int v : graph[u]) {
            if (state[v] != 2 && !dfs(graph, state, v, depth)) {
                return false;
            }
            depth[u] = Math.max(depth[u], 1 + depth[v]);
        }

        state[u] = 2;
        depth[u] = Math.max(depth[u], 1);
        return true;
    }

    private List<Integer>[] buildGraph(int n, int[][] relations) {
        List<Integer>[] g = new LinkedList[n + 1];
        for (int i = 1; i < g.length; i++) {
            g[i] = new LinkedList<>();
        }
        for (int[] rel : relations) {
            g[rel[0]].add(rel[1]);
        }
        return g;
    }
}

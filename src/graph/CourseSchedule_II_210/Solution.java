package graph.CourseSchedule_II_210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of
 * courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible
 * to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class Solution {
    // DFS
    // https://www.geeksforgeeks.org/topological-sorting/
    // https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    // tc O(V + E), sc O(V + E)
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, stack, i, visited, new boolean[numCourses])) {
                return new int[] {};
            }
        }
        return stack.size() == numCourses ? stack.stream().mapToInt(j -> j).toArray() : new int[] {};
    }

    private boolean dfs(List<Integer>[] graph, LinkedList<Integer> stack, int u, boolean[] visited, boolean[] recStack) {
        if (recStack[u]) return false; // cycle detected
        if (visited[u]) return true;
        recStack[u] = true;
        visited[u] = true;
        for (int v : graph[u]) {
            if (!dfs(graph, stack, v, visited, recStack)) return false;
        }
        stack.push(u);
        recStack[u] = false;
        return true;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }

        return graph;
    }

    // BFS
    // tc O(V + E), sc O(V + E)
    int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = getIndegrees(numCourses, prerequisites);
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        int count = 0; // count vertices with zero indegree
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                indegrees[i] = -1;
                queue.add(i);
                res.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph[u]) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    queue.add(v);
                    res.add(v);
                    count++;
                }
            }
        }

        if (count != numCourses) {
            return new int[] {};
        }

        int[] r = new int[res.size()];
        int i = 0;
        while (!res.isEmpty()) {
            r[i++] = res.poll();
        }

        return r;
    }

    private int[] getIndegrees(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
        }
        return indegrees;
    }
}

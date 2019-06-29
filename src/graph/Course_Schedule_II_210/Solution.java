package graph.Course_Schedule_II_210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
    // tc O(V + E), sc O(V + E)
    int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) return new int[] {};
        if (numCourses == 1) return new int[] {0};

        List<Integer>[] adj = buildAdj(numCourses, prerequisites);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCycle(adj, i, visited, recStack, queue)) {
                return new int[] {};
            }
        }
        int i = 0;
        int[] r = new int[queue.size()];
        while (!queue.isEmpty()) {
            r[i++] = queue.poll();
        }
        return r;
    }

    private boolean isCycle(List<Integer>[] adj, int u, boolean[] visited, boolean[] recStack, Queue<Integer> queue) {
        if (recStack[u]) return true;
        if (visited[u]) return false;

        recStack[u] = true;
        visited[u] = true;

        for (int v : adj[u]) {
            if (isCycle(adj, v, visited, recStack, queue)) {
                return true;
            }
        }

        recStack[u] = false;
        queue.add(u);
        return false;
    }

    // BFS
    // tc O(V + E), sc O(V + E)
    int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) return new int[] {};
        if (numCourses == 1) return new int[] {0};

        Stack<Integer> stack = new Stack<>();
        int[] indegrees = getIndegrees(numCourses, prerequisites);
        List<Integer>[] adj = buildAdj(numCourses, prerequisites);

        Queue<Integer> queue = new LinkedList<>();
        int count = 0; // count vertices with zero indegree
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                indegrees[i] = -1;
                queue.add(i);
                stack.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    queue.add(v);
                    stack.add(v);
                    count++;
                }
            }
        }

        if (count != numCourses) {
            return new int[] {};
        }

        int[] r = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            r[i++] = stack.pop();
        }

        return r;
    }

    private List<Integer>[] buildAdj(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        return adj;
    }

    private int[] getIndegrees(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][1]]++;
        }
        return indegrees;
    }
}

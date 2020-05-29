package graph.CourseSchedule_207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * here are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take
 * course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for
 * you to finish all courses?
 *
 * Example 1:
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists,
 * no topological ordering exists and therefore it will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic
 * concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 */

// Great solutions
// https://discuss.leetcode.com/topic/15762/java-dfs-and-bfs-solution
// https://discuss.leetcode.com/topic/17273/18-22-lines-c-bfs-dfs-solutions
// Graph additional info
//        https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/describing-graphs
//        http://www.geeksforgeeks.org/detect-cycle-in-a-graph/ - detect cycle in direct graph - DFS
//        http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/ same idea with colors, DFS
//        http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/ - depth first graph traversal.
//        https://www.youtube.com/watch?v=W9cfpsPJwhc - topological sort via DFS
//        http://www.geeksforgeeks.org/topological-sorting/ - topological sort via DFS
//        http://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
public class Solution {
    // DFS
    // tc O(V + E)
    // sc O(V + E): O(V + E) - build graph, O(V) - booleans, O(E) - max for recursion stack: O(2E + 3V) = O(E + V)
    boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) return false;

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (isCycle(graph, visited, recStack, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCycle(List<Integer>[] graph, boolean[] visited, boolean[] recStack, int ind) {
        if (recStack[ind]) return true;
        if (visited[ind]) return false;

        visited[ind] = true;
        recStack[ind] = true;

        for (int i : graph[ind]) {
            if (isCycle(graph, visited, recStack, i)) {
                return true;
            }
        }

        recStack[ind] = false;
        return false;
    }

    // BFS
    // https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
    // tc O(V + E), sc O(V + E): O(V + E) for building grpah, O(V) for indegrees, O(V) for queue => O(3V + E) => O(V + E)
    boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = buildGraph(numCourses, prerequisites);

        int[] indegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            indegrees[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0; // counter of visited vertices.

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                indegrees[i] = -1; // mark as viewed
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    count++;
                    queue.add(v);
                }
            }
        }

        return count == numCourses;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            g[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        return g;
    }
}
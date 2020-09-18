package dfs_bfs.TheMaze_490;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 490. The Maze
 * https://leetcode.com/problems/the-maze/
 *
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty
 * spaces by rolling up, down, left or right, but it won't stop rolling until hitting a
 * wall. When the ball stops, it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze, determine whether the
 * ball could stop at the destination.
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty
 * space. You may assume that the borders of the maze are all walls. The start and
 * destination coordinates are represented by row and column indexes.
 *
 * Example 1:
 * Input 1: a maze represented by a 2D array
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 *
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 *
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 *
 * Example 2:
 * Input 1: a maze represented by a 2D array
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 *
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination.
 *
 * Note:
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the
 * same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures),
 * but you could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */
public class Solution {
    // DFS
    // tc O(mn), sc O(mn)
    // 2 ms, faster than 88.47%; 40 MB, less than 89.12%
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) return false;
        return dfs(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }

    private boolean dfs(int[][] maze, int[] cur, int[] dest, boolean[][] visited) {
        int i = cur[0], j = cur[1];
        if (visited[i][j]) return false;
        if (i == dest[0] && j == dest[1]) return true;
        visited[i][j] = true;

        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            while (newI >= 0 && newI < maze.length && newJ >= 0 && newJ < maze[0].length && maze[newI][newJ] == 0) {
                newI += dir[0];
                newJ += dir[1];
            }
            if (dfs(maze, new int[] {newI - dir[0], newJ - dir[1]}, dest, visited)) return true;
        }
//        visited[i][j] = false; // uncommenting this leads to TLE!
        return false;
    }

    // BFS
    // tc O(mn), sc O(mn)
    // 7 ms, faster than 37.64%; 40.4 MB, less than 64.00%
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) return false;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            if (i == destination[0] && j == destination[1]) return true;
            visited[i][j] = true;

            int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                while (newI >= 0 && newI < maze.length && newJ >= 0 && newJ < maze[0].length && maze[newI][newJ] == 0) {
                    newI += dir[0];
                    newJ += dir[1];
                }
                if (!visited[newI - dir[0]][newJ - dir[1]]) {
                    queue.add(new int[] {newI - dir[0], newJ - dir[1]});
                }
            }
        }
        return false;
    }
}

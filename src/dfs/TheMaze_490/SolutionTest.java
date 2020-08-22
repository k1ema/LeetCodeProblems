package dfs.TheMaze_490;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[][] maze = new int[][] {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        Assert.assertTrue(s.hasPath(maze, new int[] {0, 4}, new int[] {4, 4}));
        Assert.assertFalse(s.hasPath(maze, new int[] {0, 4}, new int[] {3, 2}));
        Assert.assertTrue(s.hasPath(maze, new int[] {0, 4}, new int[] {1, 2}));

        maze = new int[][] {
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0}
        };
        Assert.assertTrue(s.hasPath(maze, new int[] {0, 0}, new int[] {8, 6}));
    }
}
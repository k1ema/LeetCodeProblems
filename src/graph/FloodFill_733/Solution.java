package graph.FloodFill_733;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. Flood Fill
 * https://leetcode.com/problems/flood-fill/
 *
 * An image is represented by a 2-D array of integers, each integer representing the pixel
 * value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
 * and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally
 * to the starting pixel of the same color as the starting pixel, plus any pixels connected
 * 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace
 * the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 *
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 *
 * Note:
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class Solution {
    // BFS, tc O(N), sc O(N)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        int initColor = image[sr][sc];
        if (newColor == initColor) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while (!q.isEmpty()) {
            int[] coord = q.poll();
            image[coord[0]][coord[1]] = newColor;
            for (int[] dir : dirs) {
                int newSr = coord[0] + dir[0];
                int newSc = coord[1] + dir[1];
                if (newSr >= 0 && newSr < m && newSc >= 0 && newSc < n && image[newSr][newSc] == initColor) {
                    q.add(new int[] {newSr, newSc});
                }
            }
        }
        return image;
    }

    // DFS, tc O(N), sc O(N)
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        if (newColor != initColor) dfs(image, sr, sc, initColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int initColor, int newColor) {
        image[sr][sc] = newColor;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int[] dir : dirs) {
            int newSr = sr + dir[0];
            int newSc = sc + dir[1];
            if (newSr >= 0 && newSr < image.length && newSc >= 0
                    && newSc < image[0].length && image[newSr][newSc] == initColor) {
                dfs(image, newSr, newSc, initColor, newColor);
            }
        }
    }
}

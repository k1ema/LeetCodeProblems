package graph.JumpGame_IV_1345;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1345. Jump Game IV
 * https://leetcode.com/problems/jump-game-iv/
 *
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 *
 * In one step you can jump from index i to index:
 *
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 * Example 1:
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 *
 * Example 2:
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You don't need to jump.
 *
 * Example 3:
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 *
 * Example 4:
 * Input: arr = [6,1,9]
 * Output: 2
 *
 * Example 5:
 * Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
 * Output: 3
 *
 * Constraints:
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 */
public class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll();
                if (idx == n - 1) return step;

                List<Integer> next = indices.get(arr[idx]);
                next.add(idx - 1);
                next.add(idx + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
                next.clear();
            }
            step++;
        }
        return 0;
    }
}

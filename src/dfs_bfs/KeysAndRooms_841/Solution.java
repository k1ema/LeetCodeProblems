package dfs_bfs.KeysAndRooms_841;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may
 * have some keys to access the next room.
 *
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where
 * N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 *
 * Initially, all the rooms start locked (except for room 0).
 *
 * You can walk back and forth between rooms freely.
 *
 * Return true if and only if you can enter every room.
 *
 * Example 1:
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 *
 * Example 2:
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 *
 * Note:
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * The number of keys in all rooms combined is at most 3000.
 */
public class Solution {
    // tc O(E + V), sc O(V)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] state = new int[rooms.size()];
        dfs(rooms, 0, state);
        return IntStream.of(state).allMatch(s -> s == 2);
    }

    private void dfs(List<List<Integer>> rooms, int u, int[] state) {
        state[u] = 1;
        for (int v : rooms.get(u)) {
            if (state[v] == 0) {
                dfs(rooms, v, state);
            }
        }
        state[u] = 2;
    }

    // tc O(E + V), sc O(V)
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : rooms.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        for (boolean b : visited) {
            if (!b) return false;
        }
        return IntStream.of(0, rooms.size() - 1).allMatch(i -> visited[i]);
    }
}

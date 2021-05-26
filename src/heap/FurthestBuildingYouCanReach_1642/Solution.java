package heap.FurthestBuildingYouCanReach_1642;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1642. Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 *
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 *
 * Example 1:
 * Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * Output: 4
 * Explanation: Starting at building 0, you can follow these steps:
 * - Go to building 1 without using ladders nor bricks since 4 >= 2.
 * - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
 * - Go to building 3 without using ladders nor bricks since 7 >= 6.
 * - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
 * It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 *
 * Example 2:
 * Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * Output: 7
 *
 * Example 3:
 * Input: heights = [14,3,19,3], bricks = 17, ladders = 0
 * Output: 3
 *
 * Constraints:
 * 1 <= heights.length <= 10^5
 * 1 <= heights[i] <= 10^6
 * 0 <= bricks <= 10^9
 * 0 <= ladders <= heights.length
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0) {
                continue;
            }
            pq.add(climb);
            if (pq.size() <= ladders) {
                continue;
            }
            if (bricks >= pq.peek()) {
                bricks -= pq.poll();
            } else {
                return i;
            }
        }
        return heights.length - 1;
    }

    // tc O(nlogn), sc O(n)
    // my solution
    public int furthestBuilding1(int[] heights, int bricks, int ladders) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0) {
                continue;
            }
            if (bricks < climb) {
                if (ladders > 0) {
                    ladders--;
                    if (!pq.isEmpty() && pq.peek() > climb) {
                        int min_height = pq.poll();
                        bricks += min_height;
                        bricks -= climb;
                        pq.add(climb);
                    }
                } else {
                    return i;
                }
            } else {
                bricks -= climb;
                pq.add(climb);
            }
        }
        return heights.length - 1;
    }

    // binary search, tc O(n * logn^2), sc O(n)
    // 697 ms, faster than 5.04%; 52.4 MB, less than 72.25%
    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        int l = 0, r = heights.length;
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (isReachable(heights, m, bricks, ladders)) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    private boolean isReachable(int[] heights, int ind, int bricks, int ladders) {
        List<Integer> climbs = new ArrayList<>();
        for (int i = 0; i < ind; i++) {
            climbs.add(heights[i + 1] - heights[i]);
        }
        Collections.sort(climbs);
        for (int climb : climbs) {
            if (climb <= 0) continue;
            if (bricks >= climb) {
                bricks -= climb;
            } else if (ladders > 0) {
                ladders--;
            } else {
                return false;
            }
        }
        return true;
    }

    // dp, recursion with memo, should be MLE
    // tc O(n), sc O(heights.length * bricks * ladders) - huge value
    public int furthestBuilding3(int[] heights, int bricks, int ladders) {
        return helper(heights, 0, bricks, ladders, new Integer[heights.length][bricks + 1][ladders + 1]);
    }

    private int helper(int[] heights, int ind, int bricks, int ladders, Integer[][][] memo) {
        if (bricks < 0 || ladders < 0) {
            return ind - 1;
        }
        int n = heights.length;
        if (ind == n - 1) return n - 1;
        if (memo[ind][bricks][ladders] != null) {
            return memo[ind][bricks][ladders];
        }
        int climb = heights[ind + 1] - heights[ind];
        int res;
        if (climb <= 0) {
            res = helper(heights, ind + 1, bricks, ladders, memo);
        } else {
            res = Math.max(helper(heights, ind + 1, bricks - climb, ladders, memo),
                    helper(heights, ind + 1, bricks, ladders - 1, memo));
        }
        return memo[ind][bricks][ladders] = res;
    }
}

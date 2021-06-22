package binarySearch.Heaters_475;

import java.util.Arrays;

/**
 * 475. Heaters
 * https://leetcode.com/problems/heaters/
 *
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed
 * warm radius to warm all the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius
 * of heaters so that all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately, and your expected output
 * will be the minimum radius standard of heaters.
 *
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 *
 *
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard,
 * then all the houses can be warmed.
 *
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard,
 * then all the houses can be warmed.
 */
public class Solution {
    // tc O(m*logn), sc O(1). m - houses.length, n - heaters.length
    // 18 ms, faster than 43.88%, 42.2 MB, less than 61.21%
    int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
            int radius = Integer.MAX_VALUE;
            int ind = findNearestHeaterIndex(houses[i], heaters);
            radius = Math.min(radius, Math.abs(houses[i] - heaters[ind]));
            res = Math.max(res, radius);
        }
        return res;
    }

    private int findNearestHeaterIndex(int target, int[] heaters) {
        int l = 0, r = heaters.length;
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (heaters[m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }
        return (l == heaters.length - 1 || (Math.abs(heaters[l] - target) <= Math.abs(heaters[l + 1] - target))) ? l : l + 1;
    }

    // brute force, tc O(mn), sc O(1). 1726 ms
    int findRadius1(int[] houses, int[] heaters) {
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
            int radius = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                radius = Math.min(radius, Math.abs(houses[i] - heaters[j]));
            }
            res = Math.max(res, radius);
        }
        return res;
    }
}

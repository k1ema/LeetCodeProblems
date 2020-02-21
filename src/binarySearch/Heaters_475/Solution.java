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
    // tc O((m + n)*logn), sc O(1). m - houses.length, n - heaters.length
    // 17 ms, faster than 32.55%, 43.2 MB, less than 23.08%
    int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int lo = 0;
            int hi = heaters.length - 1;
            int x = Integer.MAX_VALUE;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (Math.abs(heaters[mid] - houses[i]) < x) {
                    x = Math.abs(heaters[mid] - houses[i]);
                }
                if (houses[i] < heaters[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            houses[i] = x;
        }
        int max = houses[0];
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] > max) {
                max = houses[i];
            }
        }
        return max;
    }

    // brute force, tc O(mn), sc O(1). 1726 ms
    int findRadius1(int[] houses, int[] heaters) {
        for (int i = 0; i < houses.length; i++) {
            int x = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                if (Math.abs(heaters[j] - houses[i]) < x) {
                    x = Math.abs(heaters[j] - houses[i]);
                }
            }
            houses[i] = x;
        }
        int max = houses[0];
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] > max) {
                max = houses[i];
            }
        }
        return max;
    }
}

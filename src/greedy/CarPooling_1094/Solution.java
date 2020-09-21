package greedy.CarPooling_1094;

import java.util.stream.Stream;

/**
 * 1094. Car Pooling
 * https://leetcode.com/problems/car-pooling/
 *
 * You are driving a vehicle that has capacity empty seats initially available for
 * passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)
 *
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location]
 * contains information about the i-th trip: the number of passengers that must be
 * picked up, and the locations to pick them up and drop them off.  The locations
 * are given as the number of kilometers due east from your vehicle's initial location.
 *
 * Return true if and only if it is possible to pick up and drop off all passengers for
 * all the given trips.
 *
 * Example 1:
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 *
 * Example 2:
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 *
 * Example 3:
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3
 * Output: true
 *
 * Example 4:
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * Output: true
 *
 * Constraints:
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 */
public class Solution {
    // prefix sum
    // tc O(m + n), sc O(m), where n - number og trips, m - max trip location
    // 2 ms, faster than 83.76%; 39.5 MB, less than 41.91%
    public boolean carPooling(int[][] trips, int capacity) {
        int n = Stream.of(trips).mapToInt(t -> t[2]).max().orElse(0) + 1;
        int[] prefix = new int[n];
        for (int[] trip : trips) {
            prefix[trip[1]] += trip[0];
            prefix[trip[2]] -= trip[0];
        }
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }
        for (int num : prefix) {
            if (num > capacity) return false;
        }
        return true;
    }
}

package greedy.TwoCityScheduling_1029;

import java.util.Arrays;

/**
 * 1029. Two City Scheduling
 * https://leetcode.com/problems/two-city-scheduling/
 *
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A
 * is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 * Example 1:
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 * Note:
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    // let's say two person, x and y, if x[0] - x[1] < y[0] - y[1], it equals to x[0] + y[1] < y[0] + x[1],
    // which means x to A and y to B is cheaper than vice verse.
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> c1[0] - c1[1] - (c2[0] - c2[1]));
        int res = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }
        return res;
    }
}

package dynamic.MinimumCostForTickets_983;

import java.util.HashMap;
import java.util.Map;

/**
 * 983. Minimum Cost For Tickets
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * In a country popular for train travel, you have planned some train travelling one
 * year in advance. The days of the year that you will travel is given as an array days.
 * Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 *
 * The passes allow that many days of consecutive travel. For example, if we get a 7-day pass
 * on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 * Example 1:
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 *
 * Example 2:
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 *
 * Note:
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */
public class Solution {
    // tc O(days), sc O(365^2), where days is a days.length
    // 4 ms, faster than 13.73%; 40.6 MB, less than 5.21%
    public int mincostTickets(int[] days, int[] costs) {
        return helper(days, costs, 0, 0, new Integer[366][400]);
    }

    private int helper(int[] days, int[] costs, int dayInd, int validToDay, Integer[][] memo) {
        if (dayInd >= days.length) return 0;
        if (memo[dayInd][validToDay] != null) return memo[dayInd][validToDay];

        int res;
        if (days[dayInd] < validToDay) {
            res = helper(days, costs, dayInd + 1, validToDay, memo);
        } else {
            res = costs[0] + helper(days, costs, dayInd + 1, days[dayInd] + 1, memo); // 1-day ticket
            res = Math.min(res, costs[1] + helper(days, costs, dayInd + 1, days[dayInd] + 7, memo)); // 7-day ticket
            res = Math.min(res, costs[2] + helper(days, costs, dayInd + 1, days[dayInd] + 30, memo)); // 30-day ticket
        }
        memo[dayInd][validToDay] = res;

        return res;
    }

    // bottom-up
    // tc O(n), sc O(n), where n is a days.length (max = 365)
    // 1 ms, faster than 79.26%; 36.6 MB, less than 85.11%
    public int mincostTickets1(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        boolean[] travelDay = new boolean[n + 1];
        for (int day : days) {
            travelDay[day] = true;
        }
        for (int i = 0; i < dp.length; i++) {
            if (travelDay[i]) {
                int one = dp[Math.max(0, i - 1)] + costs[0];
                int seven = dp[Math.max(0, i - 7)] + costs[1];
                int thirty = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(one, Math.min(seven, thirty));
            } else {
                dp[i] = dp[Math.max(0, i - 1)];
            }
        }
        return dp[dp.length - 1];
    }

    // top-down recursive with memoization
    // tc O(n), sc O(n), where n is a days.length (max = 365)
    // 1 ms, faster than 89.33%; 38.1 MB, less than 60.97%
    public int mincostTickets2(int[] days, int[] costs) {
        return bt(days, costs, 0, days[0], new HashMap<>());
    }

    private int bt(int[] days, int[] costs, int dayInd, int validToDay, Map<Integer, Integer> memo) {
        if (dayInd == days.length) return 0;
        // tricky part: should put this condition here but not after accessing memo
        if (days[dayInd] < validToDay) {
            return bt(days, costs, dayInd + 1, validToDay, memo);
        }
        if (memo.containsKey(dayInd)) {
            return memo.get(dayInd);
        }

        int one = costs[0] + bt(days, costs, dayInd + 1, days[dayInd] + 1, memo);
        int seven = costs[1] + bt(days, costs, dayInd + 1, days[dayInd] + 7, memo);
        int thirty = costs[2] + bt(days, costs, dayInd + 1, days[dayInd] + 30, memo);
        int res = Math.min(one, Math.min(seven, thirty));
        memo.put(dayInd, res);
        return res;
    }
}

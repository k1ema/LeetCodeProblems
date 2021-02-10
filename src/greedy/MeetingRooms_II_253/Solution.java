package greedy.MeetingRooms_II_253;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get
 * new method signature.
 */
public class Solution {
    // prefix sum
    // tc O(nlogn), sc O(n)
    // 10 ms, faster than 24.12%; 39.8 MB, less than 14.24%
    // https://leetcode.com/problems/meeting-rooms-ii/discuss/67996/C%2B%2B-O(n-log-n)-584%2B-ms-3-solutions
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int[] interv : intervals) {
            pairs.add(new Pair<>(interv[0], 1));
            pairs.add(new Pair<>(interv[1], -1));
        }
        pairs.sort((a, b) -> {
            if (a.getKey().equals(b.getKey())) {
                return a.getValue() - b.getValue();
            }
            return a.getKey() - b.getKey();
        });
        int res = 0, cumsum = 0;
        for (Pair<Integer, Integer> p : pairs) {
            cumsum += p.getValue();
            res = Math.max(res, cumsum);
        }
        return res;
    }

    // tc O(nlogn), sc O(n), n - intervals.length
    // 7 ms, faster than 49.27%; 42.8 MB, less than 5.12%
    public int minMeetingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int count = 1;
        q.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int nearestEnd = q.peek();
            if (intervals[i][0] < nearestEnd) {
                count++;
            } else {
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        return count;
    }
}

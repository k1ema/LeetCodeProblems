package sorting.MeetingRooms_252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. Meeting Rooms
 * https://leetcode.com/problems/meeting-rooms/
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code
 * definition to get new method signature.
 */
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int[] prevInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevInterval[1]) {
                return false;
            } else {
                prevInterval = intervals[i];
            }
        }
        return true;
    }
}

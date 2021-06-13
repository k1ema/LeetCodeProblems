package greedy.EmployeeFreeTime_759;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 759. Employee Free Time
 * https://leetcode.com/problems/employee-free-time/
 *
 * We are given a list schedule of employees, which represents the working time for each employee.
 *
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees,
 * also in sorted order.
 *
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not
 * lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0]
 * is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 *
 * Example 1:
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 *
 * Example 2:
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 *
 * Constraints:
 * 1 <= schedule.length , schedule[i].length <= 50
 * 0 <= schedule[i].start < schedule[i].end <= 10^8
 */
public class Solution {
    // tc O(nlogn), sc O(1)
    // 12 ms, faster than 45.25%; 40.8 MB, less than 39.98%
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> flatSchedules = schedule.stream().flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(a -> a.start)).collect(Collectors.toList());
        int lastEnd = flatSchedules.get(0).end;
        for (Interval intrv : flatSchedules) {
            if (intrv.start >= lastEnd) {
                res.add(new Interval(lastEnd, intrv.start));
            }
            lastEnd = Math.max(lastEnd, intrv.end);
        }
        return res;
    }

    static class Interval {
        int start, end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Interval)) return false;
            Interval interval = (Interval) o;
            return start == interval.start && end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}

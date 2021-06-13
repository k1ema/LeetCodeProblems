package greedy.EmployeeFreeTime_759;

import greedy.EmployeeFreeTime_759.Solution.Interval;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(List.of(new Interval(3, 4)), s.employeeFreeTime(List.of(List.of(new Interval(1, 2), new Interval(5, 6)), List.of(new Interval(1, 3)), List.of(new Interval(4, 10)))));
        assertEquals(List.of(new Interval(5, 6), new Interval(7, 9)), s.employeeFreeTime(List.of(List.of(new Interval(1, 3), new Interval(6, 7)), List.of(new Interval(2, 4)), List.of(new Interval(2, 5), new Interval(9, 12)))));
    }
}
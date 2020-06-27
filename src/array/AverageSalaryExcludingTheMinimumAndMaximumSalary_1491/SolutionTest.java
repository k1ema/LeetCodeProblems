package array.AverageSalaryExcludingTheMinimumAndMaximumSalary_1491;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2500, s.average(new int[] {4000, 3000, 1000, 2000}), 0.00001);
        assertEquals(2000, s.average(new int[] {1000, 2000, 3000}), 0.00001);
        assertEquals(3500, s.average(new int[] {6000, 5000, 4000, 3000, 2000, 1000}), 0.00001);
        assertEquals(4750, s.average(new int[] {8000, 9000, 2000, 3000, 6000, 1000}), 0.00001);
    }
}
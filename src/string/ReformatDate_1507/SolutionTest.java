package string.ReformatDate_1507;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("2052-10-20", s.reformatDate("20th Oct 2052"));
        assertEquals("1933-06-06", s.reformatDate("6th Jun 1933"));
        assertEquals("1960-05-26", s.reformatDate("26th May 1960"));
    }
}
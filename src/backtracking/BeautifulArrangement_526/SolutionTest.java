package backtracking.BeautifulArrangement_526;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.countArrangement(1));
        assertEquals(2, s.countArrangement(2));
        assertEquals(3, s.countArrangement(3));
        assertEquals(8, s.countArrangement(4));
        assertEquals(24679, s.countArrangement(15));
    }
}
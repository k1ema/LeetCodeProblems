package bitManipulation.HammingDistance_461;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.hammingDistance(1, 4));
    }
}

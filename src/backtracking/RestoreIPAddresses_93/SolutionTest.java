package backtracking.RestoreIPAddresses_93;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s.restoreIpAddresses("25525511135"));
        assertEquals(Arrays.asList("0.0.0.0"), s.restoreIpAddresses("0000"));
        assertEquals(Arrays.asList("10.10.10.10", "10.10.101.0", "10.101.0.10", "101.0.10.10", "101.0.101.0"), s.restoreIpAddresses("10101010"));
    }
}
package graph.CriticalConnectionsInANetwork_1192;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(Arrays.asList(1, 3)), s.criticalConnections(4,
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0),
                        Arrays.asList(1, 3))));
        assertEquals(Collections.emptyList(), s.criticalConnections(4,
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0),
                        Arrays.asList(1, 3), Arrays.asList(0, 3))));
    }
}
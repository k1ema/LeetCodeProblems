package greedy.TaskScheduler_621;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(8, s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        assertEquals(10, s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 3));
        assertEquals(12, s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D'}, 2));
        assertEquals(15, s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D', 'E', 'E', 'E'}, 2));
        assertEquals(11, s.leastInterval(new char[] {'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B'}, 2));
        assertEquals(16, s.leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }
}
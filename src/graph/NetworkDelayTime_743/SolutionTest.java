package graph.NetworkDelayTime_743;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.networkDelayTime(new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        assertEquals(3, s.networkDelayTime(new int[][] {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1));
        assertEquals(3, s.networkDelayTime(new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}, {3, 5, 2}, {4, 5, 3}}, 5, 2));
        assertEquals(3, s.networkDelayTime(new int[][] {{1, 2, 1}, {2, 1, 3}}, 2, 2));
        assertEquals(59, s.networkDelayTime(new int[][] {{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61},
                {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0},
                {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}}, 5, 3));
    }
}

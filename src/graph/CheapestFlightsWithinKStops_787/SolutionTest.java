package graph.CheapestFlightsWithinKStops_787;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(200, s.findCheapestPrice(3, new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0, 2, 1));
        assertEquals(500, s.findCheapestPrice(3, new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0, 2, 0));
        assertEquals(6, s.findCheapestPrice(4, new int[][] {{0, 1, 1}, {1, 2, 1}, {0, 2, 5}, {2, 3, 1}},
                0, 3, 1));
        assertEquals(7, s.findCheapestPrice(5, new int[][] {{0, 1, 5}, {0, 3, 2}, {3, 1, 2}, {1, 2, 5}, {1, 4, 1}, {4, 2, 1}},
                0, 2, 2));
        assertEquals(-1, s.findCheapestPrice(4, new int[][] {{0, 3, 59}, {2, 0, 83}, {2, 3, 32}, {0, 2, 97}, {3, 1, 16}, {1, 3, 16}},
                3, 0, 3));
    }
}
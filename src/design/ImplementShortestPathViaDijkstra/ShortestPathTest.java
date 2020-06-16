package design.ImplementShortestPathViaDijkstra;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ShortestPathTest {
    @Test
    public void test() {
        ShortestPath sp = new ShortestPath();
        int[] res = sp.shortestReach(3, new int[][] {
                {0, 1, 1},
                {1, 2, 1},
                {0, 2, 5},
        }, 0);
        assertArrayEquals(new int[] {0, 1, 2}, res);
        assertEquals(Arrays.asList(0, 1, 2), sp.pathTo(2));

        res = sp.shortestReach(4, new int[][] {
                {0, 1, 1},
                {1, 2, 2},
                {0, 2, 4},
                {2, 3, 5},
        }, 0);
        assertArrayEquals(new int[] {0, 1, 3, 8}, res);
        assertEquals(Arrays.asList(0, 1, 2, 3), sp.pathTo(3));

        res = sp.shortestReach(4, new int[][] {
                {0, 1, 10},
                {1, 3, 6},
                {2, 3, 8},
        }, 0);
        assertArrayEquals(new int[] {0, 10, -1, 16}, res);
        assertEquals(Arrays.asList(0, 1, 3), sp.pathTo(3));
    }
}

package design.ImplementShortestPathViaDijkstra;

import org.junit.Assert;
import org.junit.Test;

public class ShortestPathTest {
    @Test
    public void test() {
        ShortestPath sp = new ShortestPath();
        int[] res = sp.shortestReach(4, new int[][] {
                {1, 2, 24},
                {1, 4, 20},
                {3, 1, 3},
                {4, 3, 12},
        }, 1);
        Assert.assertArrayEquals(new int[] {24, 3, 15}, res);

        res = sp.shortestReach(5, new int[][] {
                {1, 2, 10},
                {1, 3, 6},
                {2, 4, 8},
        }, 2);
        Assert.assertArrayEquals(new int[] {10, 16, 8, -1}, res);
    }
}

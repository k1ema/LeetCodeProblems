package design.ImplementTarjan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjanTest {
    @Test
    public void test() {
        Tarjan t = new Tarjan();
        int scc = t.findSCC(8, new int[][] {{6, 0}, {6, 2}, {3, 4}, {6, 4}, {2, 0}, {0, 1},
                {4, 5}, {5, 6}, {3, 7}, {7, 5}, {1, 2}, {7, 3}, {5, 0}});
        assertEquals(3, scc);
    }
}

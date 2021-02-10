package greedy.TwoCityScheduling_1029;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
//        assertEquals(110, s.twoCitySchedCost(new int[][] {{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
        assertEquals(1859, s.twoCitySchedCost(new int[][] {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));
    }
}
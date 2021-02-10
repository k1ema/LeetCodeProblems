package greedy.BoatsToSavePeople_881;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.numRescueBoats(new int[] {1, 2}, 3));
        assertEquals(3, s.numRescueBoats(new int[] {3, 2, 3, 1}, 3));
        assertEquals(4, s.numRescueBoats(new int[] {3, 5, 3, 4}, 5));
        assertEquals(12, s.numRescueBoats(new int[] {3, 5, 3, 4, 1, 1, 1, 1, 1, 2, 3, 2, 3, 3, 1, 1, 1, 2, 2, 3, 3, 1, 1}, 5));
    }
}
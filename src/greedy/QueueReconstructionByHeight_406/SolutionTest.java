package greedy.QueueReconstructionByHeight_406;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][] {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}},
                s.reconstructQueue(new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));
    }
}
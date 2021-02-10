package graph.PossibleBipartition_886;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.possibleBipartition(4, new int[][] {{1, 2}, {1, 3}, {2, 4}}));
        assertFalse(s.possibleBipartition(3, new int[][] {{1, 2}, {1, 3}, {2, 3}}));
        assertFalse(s.possibleBipartition(5, new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        assertTrue(s.possibleBipartition(10, new int[][] {{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10}, {8, 10}, {1, 5}, {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9}, {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}}));
    }
}
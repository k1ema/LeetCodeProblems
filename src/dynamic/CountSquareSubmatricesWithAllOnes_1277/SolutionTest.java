package dynamic.CountSquareSubmatricesWithAllOnes_1277;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(15, s.countSquares(new int[][] {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
        }));
        assertEquals(7, s.countSquares(new int[][] {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0},
        }));
        assertEquals(12, s.countSquares(new int[][] {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 1, 1, 1},
        }));
    }
}
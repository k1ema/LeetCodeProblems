package backtracking.NQueens_51;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(Arrays.asList(".Q..","...Q","Q...","..Q."), Arrays.asList("..Q.","Q...","...Q",".Q..")), s.solveNQueens(4));
        assertEquals(Arrays.asList(Arrays.asList("Q")), s.solveNQueens(1));
    }
}
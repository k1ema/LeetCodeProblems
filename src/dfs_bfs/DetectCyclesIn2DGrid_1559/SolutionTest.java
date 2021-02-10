package dfs_bfs.DetectCyclesIn2DGrid_1559;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.containsCycle(new char[][] {
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        }));
        assertTrue(s.containsCycle(new char[][] {
                {'c', 'c', 'c', 'a'},
                {'c', 'd', 'c', 'c'},
                {'c', 'c', 'e', 'c'},
                {'f', 'c', 'c', 'c'},
        }));
        assertFalse(s.containsCycle(new char[][] {
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'},
        }));
        assertFalse(s.containsCycle(new char[][] {
                {'b', 'a', 'c'},
                {'c', 'a', 'c'},
                {'d', 'd', 'c'},
                {'b', 'c', 'c'}
        }));
    }
}
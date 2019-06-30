package graph.Minimum_Height_Trees_310;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Collections.singletonList(1), s.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}));

        List<Integer> actual = s.findMinHeightTrees(6, new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        assertTrue(actual.equals(Arrays.asList(3, 4)) || actual.equals(Arrays.asList(4, 3)));

        actual = s.findMinHeightTrees(2, new int[][] {{0, 1}});
        assertTrue(actual.equals(Arrays.asList(1, 0)) || actual.equals(Arrays.asList(0, 1)));

        assertEquals(Collections.singletonList(3), s.findMinHeightTrees(6, new int[][] {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}));

        assertEquals(Collections.singletonList(0), s.findMinHeightTrees(1, new int[][] {{}}));
    }
}
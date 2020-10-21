package stack.AsteroidCollision_735;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {5, 10}, s.asteroidCollision(new int[] {5, 10, -5}));
        assertArrayEquals(new int[] {}, s.asteroidCollision(new int[] {8, -8}));
        assertArrayEquals(new int[] {10}, s.asteroidCollision(new int[] {10, 2, -5}));
        assertArrayEquals(new int[] {-2, -1, 1, 2}, s.asteroidCollision(new int[] {-2, -1, 1, 2}));
        assertArrayEquals(new int[] {-2, 1}, s.asteroidCollision(new int[] {-2, 1, 1, -1}));
    }
}
package greedy.JumpGame_II_45;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.jump(new int[] {2, 3, 1, 1, 4}));
        assertEquals(2, s.jump(new int[] {2, 3, 0, 1, 4}));
        assertEquals(1, s.jump(new int[] {2, 1}));
        assertEquals(2, s.jump(new int[] {4, 1, 1, 3, 1, 1, 1}));
        assertEquals(2, s.jump(new int[] {2, 3, 0, 0, 0}));
    }
}
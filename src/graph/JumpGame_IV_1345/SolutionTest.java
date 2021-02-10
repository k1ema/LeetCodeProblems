package graph.JumpGame_IV_1345;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.minJumps(new int[] {100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        assertEquals(0, s.minJumps(new int[] {7}));
        assertEquals(1, s.minJumps(new int[] {7, 6, 9, 6, 9, 6, 9, 7}));
        assertEquals(2, s.minJumps(new int[] {6, 1, 9}));
        assertEquals(3, s.minJumps(new int[] {11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
        assertEquals(2, s.minJumps(new int[] {7, 7, 7, 7, 7, 11}));
    }
}
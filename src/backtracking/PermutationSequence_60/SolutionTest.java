package backtracking.PermutationSequence_60;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
//        assertEquals("213", s.getPermutation(3, 3));
        assertEquals("3142", s.getPermutation(4, 14));
//        String str = s.getPermutation(9, 135401);
//        System.out.println(str);
    }
}

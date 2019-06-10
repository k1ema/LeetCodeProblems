package backtracking.Permutations_46;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<List<Integer>> permute = s.permute(new int[] {1, 2, 3});
        assertEquals(6, permute.size());
        System.out.println(permute);

        permute = s.permute(new int[] {1, 2, 3, 4});
        assertEquals(24, permute.size());
        System.out.println(permute);

        permute = s.permute(new int[] {1, 2, 3, 4,5});
        assertEquals(120, permute.size());
        System.out.println(permute);
    }
}

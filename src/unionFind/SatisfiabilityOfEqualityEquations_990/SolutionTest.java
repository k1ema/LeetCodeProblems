package unionFind.SatisfiabilityOfEqualityEquations_990;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.equationsPossible(new String[] {"a==b", "b!=a"}));
        assertTrue(s.equationsPossible(new String[] {"b==a", "a==b"}));
        assertTrue(s.equationsPossible(new String[] {"a==b", "b==c", "a==c"}));
        assertFalse(s.equationsPossible(new String[] {"a==b", "b!=c", "c==a"}));
        assertTrue(s.equationsPossible(new String[] {"c==c", "b==d", "x!=z"}));
    }
}
package unionFind.SatisfiabilityOfEqualityEquations_990;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertFalse(s.equationsPossible(new String[] {"a==b", "b!=a"}));
        Assert.assertTrue(s.equationsPossible(new String[] {"b==a", "a==b"}));
        Assert.assertTrue(s.equationsPossible(new String[] {"a==b", "b==c", "a==c"}));
        Assert.assertFalse(s.equationsPossible(new String[] {"a==b", "b!=c", "c==a"}));
        Assert.assertTrue(s.equationsPossible(new String[] {"c==c", "b==d", "x!=z"}));
    }
}
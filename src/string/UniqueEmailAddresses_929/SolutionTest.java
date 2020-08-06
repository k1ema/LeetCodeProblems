package string.UniqueEmailAddresses_929;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.numUniqueEmails(new String[] {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        assertEquals(2, s.numUniqueEmails(new String[] {"abc@def.com","abcd@ef.com","ab.c@def.com"}));
    }
}
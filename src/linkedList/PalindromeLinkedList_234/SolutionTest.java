package linkedList.PalindromeLinkedList_234;

import org.junit.Assert;
import org.junit.Test;

import static linkedList.utils.Parser.stringToListNode;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertTrue(s.isPalindrome(stringToListNode("[1,2,2,1]")));

        s = new Solution();
        Assert.assertFalse(s.isPalindrome(stringToListNode("[1,2]")));

        s = new Solution();
        Assert.assertTrue(s.isPalindrome(stringToListNode("[1,2,1]")));

        s = new Solution();
        Assert.assertTrue(s.isPalindrome(stringToListNode("[1,2,3,4,5,4,3,2,1]")));

        s = new Solution();
        Assert.assertFalse(s.isPalindrome(stringToListNode("[1,0,0]")));
    }
}
